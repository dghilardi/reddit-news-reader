package org.ghilardi.newsreader.model.conf;

import lombok.Data;

@Data
public class RedditRestClientConf {
    private String url;
    private String userAgent;
}
