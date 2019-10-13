package org.ghilardi.newsreader.exception;

public class NewsReaderException extends RuntimeException {

    public NewsReaderException(Throwable cause) {
        super(cause);
    }

    public NewsReaderException(String errorCode, String message) {
        super(String.format("[%s] %s", errorCode, message));
    }

    public NewsReaderException(String errorCode, String message, Throwable cause) {
        super(String.format("[%s] %s", errorCode, message), cause);
    }
}
