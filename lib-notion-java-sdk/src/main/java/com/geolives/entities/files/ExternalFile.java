package com.geolives.entities.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.FileType;

public class ExternalFile extends File{
    private ExternalFileProperties external;

    public ExternalFile() {
        super(FileType.EXTERNAL);
    }

    public ExternalFileProperties getExternal() {
        return this.external;
    }

    public void setExternal(final ExternalFileProperties external) {
        this.external = external;
    }
    @JsonIgnore()
    public String getUrl() {
        return this.external.getUrl();
    }
    @JsonIgnore()
    public void setUrl(final String url) {
        this.external.setUrl(url);
    }

}
