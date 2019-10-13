package org.ghilardi.newsreader.client;

import org.ghilardi.newsreader.exception.NewsReaderError;
import org.ghilardi.newsreader.exception.NewsReaderExceptionBuilder;
import org.ghilardi.newsreader.factory.NewsFactory;
import org.ghilardi.newsreader.model.conf.RedditRestClientConf;
import org.ghilardi.newsreader.model.dto.reddit.core.RedditBaseDto;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        HttpEntity<Void> request = buildRequest(null);
        RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto> response = restClient.exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto>>() {
                }
        ).getBody();

        if (!isFetchTodayILearnedTopResponseValid(response)) {
            throw NewsReaderExceptionBuilder.buildException(NewsReaderError.MALFORMED_REST_RESPONSE, url);
        }

        return newsFactory.createNewsFromFetchTodayILearnedResponse(response);
    }

    private <REQUEST_TYPE> HttpEntity<REQUEST_TYPE> buildRequest(REQUEST_TYPE body) {
        MultiValueMap<String, String> headers = buildHeaders();
        return new HttpEntity<>(body, headers);
    }

    private MultiValueMap<String, String> buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.USER_AGENT, conf.getUserAgent());
        headers.set(HttpHeaders.CACHE_CONTROL, buildCacheControlHeader());
        return headers;
    }

    private String buildCacheControlHeader() {
        return Arrays.asList(
                Optional.ofNullable(conf.getMaxAge()).map(val -> String.format("max-age=%d", val)),
                Optional.ofNullable(conf.getMaxStale()).map(val -> String.format("max-stale=%d", val)),
                Optional.ofNullable(conf.getMinFresh()).map(val -> String.format("min-fresh=%d", val))
        )
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.joining(", "));
    }


    private boolean isFetchTodayILearnedTopResponseValid(RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto> response) {
        return response != null
                && response.getData() != null
                && response.getData().getChildren() != null;
    }
}
