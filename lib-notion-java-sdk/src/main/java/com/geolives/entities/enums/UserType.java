package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.UserTypeConstants;

public enum UserType {
    PERSON(UserTypeConstants.PERSON),
    BOT(UserTypeConstants.BOT);

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static UserType fromValue(String value) {
        for (UserType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
