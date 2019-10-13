package org.ghilardi.newsreader.conf;

import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConf {
    @Bean
    public Settings settings() {
        return new Settings()
                .withRenderNameStyle(RenderNameStyle.LOWER);
    }
}
