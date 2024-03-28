package com.geolives.entities.blocks.richtexts.mentions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geolives.entities.enums.MentionRichTextType;
import com.geolives.entities.enums.constants.MentionRichTextTypeConstants;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PageMention.class, name = MentionRichTextTypeConstants.PAGE)
})
public abstract class Mention {
    @JsonIgnore()
    private MentionRichTextType type;

    public Mention() {}
    public Mention(final MentionRichTextType type) {
        this.type = type;
    }

    public MentionRichTextType getType() {
        return this.type;
    }

    public void setType(final MentionRichTextType type) {
        this.type = type;
    }
}
