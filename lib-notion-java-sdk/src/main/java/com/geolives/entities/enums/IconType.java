package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.IconTypeConstants;

public enum IconType {
    INETRNAL_FILE(IconTypeConstants.INTERNAL_FILE),
    EXTERNAL_FILE(IconTypeConstants.EXTERNAL_FILE),
    EMOJI(IconTypeConstants.EMOJI);

    private final String value;

    IconType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static IconType fromValue(String value) {
        for (IconType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
