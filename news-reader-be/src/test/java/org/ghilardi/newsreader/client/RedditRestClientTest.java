package org.ghilardi.newsreader.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ghilardi.newsreader.factory.NewsFactory;
import org.ghilardi.newsreader.model.conf.RedditRestClientConf;
import org.ghilardi.newsreader.model.dto.reddit.core.RedditBaseDto;
import org.ghilardi.newsreader.model.dto.reddit.news.RedditNewsDataDto;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RedditRestClientTest {

    @Test
    public void fetchTopNews() throws IOException {
        RedditRestClient redditRestClient = givenRedditRestClient("reddit/todayilearnedtop.json");
        List<NewsItem> topNews = redditRestClient.fetchTopNews();
        assertEquals(25, topNews.size());
    }

    private RedditRestClient givenRedditRestClient(String responseResourcePath) throws IOException {
        RedditRestClientConf conf = new RedditRestClientConf();
        conf.setUrl("http://mock");

        String serviceUrl = conf.getUrl() + RedditRestClient.URL_TODAY_I_LEARNED_TOP;
        RestTemplate mockedRestClient = mock(RestTemplate.class);
        when(mockedRestClient.exchange(
                eq(serviceUrl),
                eq(HttpMethod.GET),
                any(),
                eq(new ParameterizedTypeReference<RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto>>() { })
        ))
                .thenReturn(responseFromResource(responseResourcePath));

        NewsFactory newsFactory = new NewsFactory();

        return new RedditRestClient(
                conf,
                mockedRestClient,
                newsFactory
        );
    }

    private ResponseEntity<RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto>> responseFromResource(String resourcePath) throws IOException {
        ObjectMapper om = new ObjectMapper();
        JavaType responseType = om.getTypeFactory().constructParametricType(RedditBaseDto.RedditListingDto.class, RedditBaseDto.RedditNewsDto.class);
        RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto> response = om.readValue(new ClassPathResource(resourcePath).getInputStream(), responseType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}