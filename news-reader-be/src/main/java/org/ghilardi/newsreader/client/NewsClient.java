package org.ghilardi.newsreader.client;

import org.ghilardi.newsreader.model.news.NewsItem;

import java.util.List;

public interface NewsClient {
    List<NewsItem> fetchTopNews();
}
