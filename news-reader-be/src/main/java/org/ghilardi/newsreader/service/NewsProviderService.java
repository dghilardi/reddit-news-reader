package org.ghilardi.newsreader.service;

import org.ghilardi.newsreader.client.NewsClient;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsProviderService {
    private final NewsClient newsClient;

    public NewsProviderService(NewsClient redditRestClient) {
        this.newsClient = redditRestClient;
    }

    public List<NewsItem> fetchTopNews(int itemsToFetch) {
        List<NewsItem> news = this.newsClient.fetchTopNews();
        return news
                .stream()
                .limit(itemsToFetch)
                .collect(Collectors.toList());
    }
}
