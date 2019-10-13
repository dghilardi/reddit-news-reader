package org.ghilardi.newsreader.factory;

import org.ghilardi.newsreader.model.dto.reddit.core.RedditBaseDto;
import org.ghilardi.newsreader.model.dto.reddit.news.RedditNewsDataDto;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.ghilardi.newsreader.tables.records.NewsRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsFactory {
    public List<NewsItem> createNewsFromFetchTodayILearnedResponse(RedditBaseDto.RedditListingDto<RedditBaseDto.RedditNewsDto> fetchTodayILearnedTopResponse) {
        return fetchTodayILearnedTopResponse
                .getData()
                .getChildren()
                .stream()
                .map(RedditBaseDto::getData)
                .map(this::mapRedditNewsDtoToNewsItem)
                .collect(Collectors.toList());
    }

    private NewsItem mapRedditNewsDtoToNewsItem(RedditNewsDataDto redditNewsDto) {
        return NewsItem.builder()
                .id(redditNewsDto.getId())
                .author(redditNewsDto.getAuthor())
                .authorFullname(redditNewsDto.getAuthorFullname())
                .title(redditNewsDto.getTitle())
                .downs(redditNewsDto.getDowns())
                .ups(redditNewsDto.getUps())
                .score(redditNewsDto.getScore())
                .thumbnail(redditNewsDto.getThumbnail())
                .edited(redditNewsDto.getEdited())
                .over18(redditNewsDto.getOver18())
                .numComments(redditNewsDto.getNumComments())
                .url(redditNewsDto.getUrl())
                .created(toOffsetDateTime(redditNewsDto.getCreatedUtc()))
                .isVideo(redditNewsDto.getIsVideo())
                .build();
    }

    private OffsetDateTime toOffsetDateTime(Integer timestamp) {
        LocalDateTime dateTS = LocalDateTime.ofEpochSecond(
                timestamp,
                0,
                ZoneOffset.UTC
        );

        return dateTS.atOffset(ZoneOffset.UTC);
    }

    public List<NewsItem> createNewsFromNewsRecords(List<NewsRecord> newsRecords) {
        return newsRecords.stream()
                .map(this::mapNewsRecordsToNewsItem)
                .collect(Collectors.toList());
    }

    private NewsItem mapNewsRecordsToNewsItem(NewsRecord record) {
        return NewsItem.builder()
                .id(record.getId())
                .author(record.getAuthor())
                .authorFullname(record.getAuthorFullName())
                .title(record.getTitle())
                .downs(record.getDowns())
                .ups(record.getUps())
                .score(record.getScore())
                .thumbnail(record.getThumbnail())
                .edited(record.getEdited())
                .over18(record.getOver_18())
                .numComments(record.getNumComments())
                .url(record.getUrl())
                .created(record.getCreated().atOffset(ZoneOffset.UTC))
                .isVideo(record.getIsVideo())
                .build();
    }
}
