package org.ghilardi.newsreader.service;

import org.ghilardi.newsreader.client.RedditRestClient;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewsProviderServiceTest {

    @Test
    public void verifyNewsProviderReturnsNoMoreThanExpectedItemsNumber() {
        NewsProviderService newsProviderService = givenNewsProviderService(stubNewsList(5));
        List<NewsItem> topNews = newsProviderService.fetchTopNews(3);
        assertEquals(3, topNews.size());
    }

    @Test
    public void verifyNewsProviderReturnsAllItemsIfLessThanLimit() {
        NewsProviderService newsProviderService = givenNewsProviderService(stubNewsList(5));
        List<NewsItem> topNews = newsProviderService.fetchTopNews(8);
        assertEquals(5, topNews.size());
    }

    private NewsProviderService givenNewsProviderService(List<NewsItem> stubbedNews) {
        RedditRestClient mockedRedditRestClient = mock(RedditRestClient.class);
        when(mockedRedditRestClient.fetchTopNews()).thenReturn(stubbedNews);

        return new NewsProviderService(mockedRedditRestClient);
    }

    private List<NewsItem> stubNewsList(int limit) {
        return Arrays.asList(
                NewsItem.builder().title("TITLE 1").build(),
                NewsItem.builder().title("TITLE 2").build(),
                NewsItem.builder().title("TITLE 3").build(),
                NewsItem.builder().title("TITLE 4").build(),
                NewsItem.builder().title("TITLE 5").build()
        ).subList(0, limit);
    }
}