package org.ghilardi.newsreader.factory;

import org.ghilardi.newsreader.model.news.NewsItem;
import org.ghilardi.newsreader.tables.records.NewsRecord;
import org.ghilardi.newsreader.utils.SqlUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsRecordsFactory {
    public List<NewsRecord> createNewsItemsRecordsFromNews(List<NewsItem> news) {
        return news
                .stream()
                .map(this::mapNewsToNewsRecord)
                .collect(Collectors.toList());
    }

    private NewsRecord mapNewsToNewsRecord(NewsItem news) {
        NewsRecord record = new NewsRecord();
        record.setId(SqlUtils.clampField("ID", news.getId(), 50));
        record.setAuthor(SqlUtils.clampField("AUTHOR", news.getAuthor(), 50));
        record.setAuthorFullName(SqlUtils.clampField("AUTHOR_FULL_NAME", news.getAuthorFullname(), 100));
        record.setTitle(SqlUtils.clampField("TITLE", news.getTitle(), 500));
        record.setDowns(news.getDowns());
        record.setUps(news.getUps());
        record.setScore(news.getScore());
        record.setThumbnail(SqlUtils.clampField("THUMBNAIL", news.getThumbnail(), 200));
        record.setEdited(news.getEdited());
        record.setOver_18(news.getOver18());
        record.setNumComments(news.getNumComments());
        record.setUrl(SqlUtils.clampField("URL", news.getUrl(), 200));
        record.setCreated(news.getCreated() == null ? null : news.getCreated().toLocalDateTime());
        record.setIsVideo(news.getIsVideo());
        return record;
    }
}
