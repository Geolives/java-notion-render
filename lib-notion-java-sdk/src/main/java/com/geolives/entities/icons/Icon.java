package com.geolives.entities.icons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geolives.entities.enums.IconType;
import com.geolives.entities.enums.constants.IconTypeConstants;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InternalFileIcon.class, name = IconTypeConstants.INTERNAL_FILE),
        @JsonSubTypes.Type(value = ExternalFileIcon.class, name = IconTypeConstants.EXTERNAL_FILE),
        @JsonSubTypes.Type(value = EmojiIcon.class, name = IconTypeConstants.EMOJI)
})
public abstract class Icon {
    @JsonIgnore()
    private IconType type;

    public Icon() {}
    public Icon(final IconType type) {
        this.type = type;
    }

    public IconType getType() {
        return this.type;
    }

    public void setType(final IconType type) {
        this.type = type;
    }
}
