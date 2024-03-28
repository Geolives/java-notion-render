package com.geolives.exceptions;

public class NotionApiException extends NotionException {
    public NotionApiException(final String message) {
        super(message);
    }
    public NotionApiException(final Exception ex) {
        super(ex);
    }
    public NotionApiException(final String message, final Exception ex) {
        super(message, ex);
    }
}
