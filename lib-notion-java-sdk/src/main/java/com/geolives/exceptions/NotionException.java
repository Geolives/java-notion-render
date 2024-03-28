package com.geolives.exceptions;

public class NotionException extends Exception {
    public NotionException(final String errorMessage) {
        super(errorMessage);
    }
    public NotionException(final Exception ex) {
        super(ex);
    }
    public NotionException(final String errorMessage, final Exception ex) {
        super(errorMessage, ex);
    }

}
