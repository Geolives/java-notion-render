package com.geolives.exceptions;

public class NotionIllegalArgumentException extends NotionException {
    public NotionIllegalArgumentException(String errorMessage) {
        super(errorMessage);
    }

    public NotionIllegalArgumentException(Exception ex) {
        super(ex);
    }

    public NotionIllegalArgumentException(String errorMessage, Exception ex) {
        super(errorMessage, ex);
    }
}
