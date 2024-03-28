package com.geolives.entities.icons;

import com.geolives.entities.enums.IconType;
import com.geolives.entities.files.InternalFileProperties;

public class InternalFileIcon extends Icon {
    private InternalFileProperties file;

    public InternalFileIcon() {
        super(IconType.INETRNAL_FILE);
    }

    public InternalFileProperties getFile() {
        return this.file;
    }

    public void setFile(final InternalFileProperties file) {
        this.file = file;
    }

}
