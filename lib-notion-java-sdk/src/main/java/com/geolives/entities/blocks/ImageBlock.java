package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.files.ExternalFile;
import com.geolives.entities.files.File;
import com.geolives.entities.files.InternalFile;

public class ImageBlock extends Block {
    private File image;

    public ImageBlock() {
        super(BlockType.IMAGE);
    }

    public File getImage() {
        return this.image;
    }

    public void setImage(final File image) {
        this.image = image;
    }
    @JsonIgnore()
    public String getImageUrl() {
        if(this.image instanceof ExternalFile) {
            return ((ExternalFile) this.image).getUrl();
        } else if (this.image instanceof InternalFile) {
            return ((InternalFile) this.image).getUrl();
        } else {
            return null;
        }
    }
    @JsonIgnore()
    public void setImageUrl(final String url) {
        if(this.image instanceof ExternalFile) {
            ((ExternalFile) this.image).setUrl(url);
        } else if (this.image instanceof InternalFile) {
            ((InternalFile) this.image).setUrl(url);
        }
    }
}
