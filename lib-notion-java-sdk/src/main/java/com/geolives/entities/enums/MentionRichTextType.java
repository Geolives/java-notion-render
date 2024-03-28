package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.MentionRichTextTypeConstants;

public enum MentionRichTextType {
    DATABASE(MentionRichTextTypeConstants.DATABASE),
    DATE(MentionRichTextTypeConstants.DATE),
    LINK_PREVIEW(MentionRichTextTypeConstants.LINK_PREVIEW),
    PAGE(MentionRichTextTypeConstants.PAGE),
    TEMPLATE_MENTION(MentionRichTextTypeConstants.TEMPLATE_MENTION),
    USER(MentionRichTextTypeConstants.USER);


    private final String value;

    MentionRichTextType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static MentionRichTextType fromValue(String value) {
        for (MentionRichTextType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
