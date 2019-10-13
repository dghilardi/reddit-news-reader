package org.ghilardi.newsreader.model.conf;

import lombok.Data;

@Data
public class NewsFormatterConf {
    private String header;
    private String footer;
    private String rowTemplate;
}
