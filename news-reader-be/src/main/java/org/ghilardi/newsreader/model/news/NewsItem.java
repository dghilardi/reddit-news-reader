package org.ghilardi.newsreader.model.news;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class NewsItem {
    private final String author;
    private final String authorFullname;
    private final String title;
    private final Integer downs;
    private final Integer ups;
    private final Integer score;
    private final String thumbnail;
    private final Boolean edited;
    private final Boolean over18;
    private final Integer numComments;
    private final String url;
    private final OffsetDateTime created;
    private final Boolean isVideo;
}
