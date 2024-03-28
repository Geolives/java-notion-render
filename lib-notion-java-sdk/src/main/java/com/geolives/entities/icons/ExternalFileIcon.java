package com.geolives.entities.icons;

import com.geolives.entities.enums.IconType;
import com.geolives.entities.files.ExternalFileProperties;

public class ExternalFileIcon extends Icon {
    private ExternalFileProperties external;

    public ExternalFileIcon() {
        super(IconType.EXTERNAL_FILE);
    }

    public ExternalFileProperties getExternal() {
        return this.external;
    }

    public void setExternal(final ExternalFileProperties file) {
        this.external = file;
    }

}
