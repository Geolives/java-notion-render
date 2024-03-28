package com.geolives.exceptions;

public class NotionBuildUrlException extends NotionException {
    public NotionBuildUrlException(final String message) {
        super(message);
    }
    public NotionBuildUrlException(final Exception ex) {
        super(ex);
    }
    public NotionBuildUrlException(final String message, final Exception ex) {
        super(message, ex);
    }
}
