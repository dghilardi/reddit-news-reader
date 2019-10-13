package org.ghilardi.newsreader.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewsReaderExceptionBuilder {
    public static <ERR extends Enum<ERR> & ErrorInterface> NewsReaderException buildException(ERR error, Object ... args) {
        if (error == null) {
            log.error("null value given as an error");
            throw buildException(NewsReaderError.UNEXPECTED_NULL, "error");
        }

        try {
            String formattedMessage = String.format(error.message(), args);
            String code = String.format("%s.%s", error.group(), error.code());

            if (args.length > 0 && args[args.length - 1] != null && args[args.length - 1] instanceof Throwable) {
                return new NewsReaderException(code, formattedMessage, (Throwable) args[args.length - 1]);
            } else {
                return new NewsReaderException(code, formattedMessage);
            }
        } catch (Exception ex) {
            throw buildException(NewsReaderError.EXCEPTION_MESSAGE_ERROR, ex.getMessage(), ex);
        }
    }
}
