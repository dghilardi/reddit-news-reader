package org.ghilardi.newsreader.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ghilardi.newsreader.exception.NewsReaderError;
import org.ghilardi.newsreader.exception.NewsReaderExceptionBuilder;
import org.ghilardi.newsreader.factory.NewsFactory;
import org.ghilardi.newsreader.model.conf.RedditRestClientConf;
import org.ghilardi.newsreader.model.dto.reddit.core.RedditBaseDto;
import org.ghilardi.newsreader.model.dto.reddit.news.RedditNewsDataDto;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RedditRestClient implements NewsClient {
    protected static final String URL_TODAY_I_LEARNED_TOP = "/r/todayilearned/top.json";

    private final RedditRestClientConf conf;
    private final RestTemplate restClient;
    private final NewsFactory newsFactory;

    public RedditRestClient(RedditRestClientConf conf, RestTemplate restClient, NewsFactory newsFactory) {
        this.conf = conf;
        this.restClient = restClient;
        this.newsFactory = newsFactory;
    }

    @Override
    public List<NewsItem> fetchTopNews() {
        final String url = conf.getUrl() + URL_TODAY_I_LEARNED_TOP;
        ObjectMapper om = new ObjectMapper();
        JavaType responseType = om.getTypeFactory().constructParametricType(RedditBaseDto.RedditListingDto.class, RedditBaseDto.RedditNewsDto.class);
        RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto> response = restClient.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto>>() { }
        ).getBody();

        if (!isFetchTodayILearnedTopResponseValid(response)) {
            throw NewsReaderExceptionBuilder.buildException(NewsReaderError.MALFORMED_REST_RESPONSE, url);
        }

        return newsFactory.createNewsFromFetchTodayILearnedResponse(response);
    }

    private boolean isFetchTodayILearnedTopResponseValid(RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto> response) {
        return response != null
                && response.getData() != null
                && response.getData().getChildren() != null;
    }
}
