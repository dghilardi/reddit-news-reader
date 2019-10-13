package org.ghilardi.newsreader.repository;

import org.ghilardi.newsreader.factory.NewsFactory;
import org.ghilardi.newsreader.factory.NewsRecordsFactory;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.ghilardi.newsreader.tables.News;
import org.ghilardi.newsreader.tables.records.NewsRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsRepository {
    private final DSLContext dsl;

    private final NewsRecordsFactory newsRecordsFactory;
    private final NewsFactory newsFactory;

    public NewsRepository(DSLContext dsl, NewsRecordsFactory newsRecordsFactory, NewsFactory newsFactory) {
        this.dsl = dsl;
        this.newsRecordsFactory = newsRecordsFactory;
        this.newsFactory = newsFactory;
    }

    public void batchInsert(List<NewsItem> news) {
        List<NewsRecord> newsRecords = newsRecordsFactory.createNewsItemsRecordsFromNews(news);
        dsl.batchInsert(newsRecords).execute();
    }

    public void update(List<NewsItem> news) {
        List<NewsRecord> newsRecords = newsRecordsFactory.createNewsItemsRecordsFromNews(news);
        newsRecords.forEach(record -> dsl.update(News.NEWS).set(record).where(News.NEWS.ID.eq(record.getId())).execute());
    }

    public List<NewsItem> fetchById(List<String> ids) {
        List<NewsRecord> newsRecords = dsl.select()
                .from(News.NEWS)
                .where(News.NEWS.ID.in(ids))
                .fetch()
                .into(NewsRecord.class);

        return newsFactory.createNewsFromNewsRecords(newsRecords);
    }
}
