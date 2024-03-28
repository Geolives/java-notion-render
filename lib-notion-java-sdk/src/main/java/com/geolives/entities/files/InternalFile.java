package com.geolives.entities.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.FileType;

import java.time.ZonedDateTime;

public class InternalFile extends File {
    private InternalFileProperties file;

    public InternalFile() {
        super(FileType.INTERNAL);
    }
    @JsonIgnore()
    public String getUrl() {
        return this.file.getUrl();
    }
    @JsonIgnore()
    public void setUrl(final String url) {
        this.file.setUrl(url);
    }
    @JsonIgnore()
    public ZonedDateTime getExpiryTime() {
        return this.file.getExpiryTime();
    }
    @JsonIgnore()
    public void setExpiryTime(final ZonedDateTime expiryTime) {
        this.file.setExpiryTime(expiryTime);
    }

    public InternalFileProperties getFile() {
        return this.file;
    }

    public void setFile(final InternalFileProperties file) {
        this.file = file;
    }

}
