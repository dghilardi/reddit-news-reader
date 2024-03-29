package org.ghilardi.newsreader.command;

import org.ghilardi.newsreader.model.conf.PrintLatestNewsCommandConf;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.ghilardi.newsreader.service.NewsFormatterService;
import org.ghilardi.newsreader.service.NewsProviderService;
import org.ghilardi.newsreader.service.NewsStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintLatestNewsCommand {

    private final PrintLatestNewsCommandConf conf;
    private final NewsProviderService newsProviderService;
    private final NewsStoreService newsStoreService;
    private final NewsFormatterService newsFormatterService;

    public PrintLatestNewsCommand(
            PrintLatestNewsCommandConf conf,
            NewsProviderService newsProviderService,
            NewsStoreService newsStoreService,
            NewsFormatterService newsFormatterService
    ) {
        this.conf = conf;
        this.newsProviderService = newsProviderService;
        this.newsStoreService = newsStoreService;
        this.newsFormatterService = newsFormatterService;
    }

    public void execute() {
        List<NewsItem> news = newsProviderService.fetchTopNews(conf.getNewsCount());
        newsStoreService.insertNews(news);
        String formattedMessage = newsFormatterService.renderNews(news);
        System.out.print(formattedMessage);
    }
}
