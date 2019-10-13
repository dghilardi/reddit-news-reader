package org.ghilardi.newsreader.service;

import org.ghilardi.newsreader.model.news.NewsItem;
import org.ghilardi.newsreader.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsStoreService {
    private final NewsRepository newsRepository;

    public NewsStoreService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void insertNews(List<NewsItem> news) {
        List<String> alreadyStoredIds = extractAlreadyStoredIds(news);

        List<NewsItem> newsToInsert = news.stream().filter(newsItem -> !alreadyStoredIds.contains(newsItem.getId())).collect(Collectors.toList());
        newsRepository.batchInsert(newsToInsert);

        List<NewsItem> newsToUpdate = news.stream().filter(newsItem -> alreadyStoredIds.contains(newsItem.getId())).collect(Collectors.toList());
        newsRepository.update(newsToUpdate);
    }

    private List<String> extractAlreadyStoredIds(List<NewsItem> news) {
        List<String> newsIds = news.stream().map(NewsItem::getId).collect(Collectors.toList());
        List<NewsItem> alreadyStoredNews = newsRepository.fetchById(newsIds);
        return alreadyStoredNews.stream().map(NewsItem::getId).collect(Collectors.toList());
    }
}
