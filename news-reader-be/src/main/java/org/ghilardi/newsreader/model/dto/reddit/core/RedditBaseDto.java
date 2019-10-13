package org.ghilardi.newsreader.model.dto.reddit.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.ghilardi.newsreader.model.dto.reddit.news.RedditNewsDataDto;

@Data
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="kind")
@JsonSubTypes({
        @JsonSubTypes.Type(name = RedditBaseDto.LISTING_TYPE, value = RedditBaseDto.RedditListingDto.class),
        @JsonSubTypes.Type(name = RedditBaseDto.NEWS_TYPE, value = RedditBaseDto.RedditNewsDto.class)
})
public class RedditBaseDto<CONTENT extends RedditContentDto> {
    public static final String LISTING_TYPE = "Listing";
    public static final String NEWS_TYPE = "t3";

    private final String kind;
    private CONTENT data;

    public static class RedditListingDto<LISTING_TYPE extends RedditBaseDto>
            extends RedditBaseDto<RedditListingDataDto<LISTING_TYPE>> {
        public RedditListingDto() {
            super(LISTING_TYPE);
        }
    }

    public static class RedditNewsDto extends RedditBaseDto<RedditNewsDataDto> {
        public RedditNewsDto() {
            super(NEWS_TYPE);
        }
    }
}
