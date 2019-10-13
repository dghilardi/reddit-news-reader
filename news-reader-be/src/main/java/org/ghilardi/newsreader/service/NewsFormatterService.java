package org.ghilardi.newsreader.service;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.ghilardi.newsreader.model.conf.NewsFormatterConf;
import org.ghilardi.newsreader.model.news.NewsItem;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

@Service
public class NewsFormatterService {
    private final NewsFormatterConf conf;
    private final Mustache rowTemplate;

    public NewsFormatterService(NewsFormatterConf conf) {
        this.conf = conf;

        MustacheFactory mf = new DefaultMustacheFactory();
        rowTemplate = mf.compile(new StringReader(conf.getRowTemplate()), "news.row.template");
    }

    public String renderNews(List<NewsItem> newsLst) {
        return filterBlankStrings(conf.getHeader())
                + generateBody(newsLst)
                + "\n" + filterBlankStrings(conf.getFooter());
    }

    private String generateBody(List<NewsItem> newsLst) {
        StringWriter result = new StringWriter();
        newsLst.forEach(row -> {
            result.append('\n');
            rowTemplate.execute(result, row);
        });
        result.flush();
        return result.toString();
    }

    private String filterBlankStrings(String val) {
        return Optional.ofNullable(val)
                .filter(StringUtils::hasText)
                .map(String::trim)
                .orElse("");
    }
}
