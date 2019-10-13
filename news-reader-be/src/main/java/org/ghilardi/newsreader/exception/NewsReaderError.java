package org.ghilardi.newsreader.exception;

public enum NewsReaderError implements ErrorInterface {
    UNEXPECTED_NULL("001", "Unexpected null value for field %s"),
    EXCEPTION_MESSAGE_ERROR("002", "Error generating exception message: %s"),

    MALFORMED_REST_RESPONSE("101", "Received malformed response from %s")
    ;

    private final String code;
    private final String message;

    NewsReaderError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public String group() { return "COMMON"; }
}
