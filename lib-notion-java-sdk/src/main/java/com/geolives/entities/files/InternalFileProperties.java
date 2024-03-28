package com.geolives.entities.files;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class InternalFileProperties {
    private String url;
    private ZonedDateTime expiryTime;

    public InternalFileProperties() {}

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public ZonedDateTime getExpiryTime() {
        return this.expiryTime;
    }

    public void setExpiryTime(final ZonedDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
