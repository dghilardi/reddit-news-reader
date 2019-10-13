package org.ghilardi.newsreader.conf;

import org.ghilardi.newsreader.model.conf.RedditRestClientConf;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NewsReaderConf {
    @Bean
    public RestTemplate restTemplateBean(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    @ConfigurationProperties("reddit")
    public RedditRestClientConf redditRestClientConf() {
        return new RedditRestClientConf();
    }
}
