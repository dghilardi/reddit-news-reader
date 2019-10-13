package org.ghilardi.newsreader.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlUtils.class);

    public static String clampField(String fieldName, String in, int maxChars) {
        if (in != null && in.length() > maxChars) {
            LOGGER.warn("Warning! field {} is too long ({} chars). Clamping to {} chars", fieldName, in.length(), maxChars);
            return in.substring(0, maxChars);
        }
        return in;
    }
}
