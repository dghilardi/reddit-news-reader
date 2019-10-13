package org.ghilardi.newsreader.model.dto.reddit.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class RedditListingDataDto<CHILDREN_TYPE extends RedditBaseDto> extends RedditContentDto {
    private final String modhash;
    private final Integer dist;
    private final String after;
    private final String before;
    private final List<CHILDREN_TYPE> children;
}
