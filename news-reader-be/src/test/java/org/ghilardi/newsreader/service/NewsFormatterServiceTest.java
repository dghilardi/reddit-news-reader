package org.ghilardi.newsreader.service;

import org.ghilardi.newsreader.model.conf.NewsFormatterConf;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NewsFormatterServiceTest {
    private static final String EXPECTED_OUTPUT = "Today I Learned:\n" +
                    "* TEST TITLE 1 - thumb 1\n" +
                    "* TEST TITLE 2 - thumb 2\n" +
                    "* TEST TITLE 3 - thumb 3\n";

    @Test
    public void testNewsFormatter() {
        NewsFormatterService newsFormatterService = givenNewsFormatterService("Today I Learned:", "* {{title}} - {{thumbnail}}", "");
        String renderedNews = newsFormatterService.renderNews(generateNewsList());
        assertEquals(EXPECTED_OUTPUT, renderedNews);
    }

    private List<NewsItem> generateNewsList() {
        return Arrays.asList(
                NewsItem.builder().title("TEST TITLE 1").thumbnail("thumb 1").build(),
                NewsItem.builder().title("TEST TITLE 2").thumbnail("thumb 2").build(),
                NewsItem.builder().title("TEST TITLE 3").thumbnail("thumb 3").build()
        );
    }

    private NewsFormatterService givenNewsFormatterService(
            String header,
            String template,
            String footer
    ) {
        NewsFormatterConf conf = new NewsFormatterConf();
        conf.setHeader(header);
        conf.setRowTemplate(template);
        conf.setFooter(footer);

        return new NewsFormatterService(conf);
    }

}