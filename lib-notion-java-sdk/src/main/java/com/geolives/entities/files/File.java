package com.geolives.entities.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geolives.entities.enums.FileType;
import com.geolives.entities.enums.constants.FileTypeConstants;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InternalFile.class, name = FileTypeConstants.INTERNAL),
        @JsonSubTypes.Type(value = ExternalFile.class, name = FileTypeConstants.EXTERNAL)
})
public abstract class File {
    @JsonIgnore()
    private FileType type;

    public File() {}
    public File(final FileType type) {
        this.type = type;
    }

    public FileType getType() {
        return this.type;
    }

    public void setType(final FileType type) {
        this.type = type;
    }
}
