package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.RichTextTypeConstants;

public enum RichTextType {
    TEXT(RichTextTypeConstants.TEXT),
    MENTION(RichTextTypeConstants.MENTION),
    EQUATION(RichTextTypeConstants.EQUATION);

    private final String value;

    RichTextType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static RichTextType fromValue(String value) {
        for (RichTextType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
