package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.FileTypeConstants;

public enum FileType {
    INTERNAL(FileTypeConstants.INTERNAL),
    EXTERNAL(FileTypeConstants.EXTERNAL);

    private final String value;

    FileType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static FileType fromValue(String value) {
        for (FileType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
