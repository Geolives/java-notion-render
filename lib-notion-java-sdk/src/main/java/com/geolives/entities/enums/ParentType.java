package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import com.geolives.entities.enums.constants.ParentTypeConstants;

public enum ParentType {
    DATABASEID(ParentTypeConstants.DATABASE),
    PAGE(ParentTypeConstants.PAGE),
    WORKSPACE(ParentTypeConstants.WORKSPACE),
    BLOCK(ParentTypeConstants.BLOCK);

    private final String value;

    ParentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static ParentType fromValue(String value) {
        for (ParentType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
