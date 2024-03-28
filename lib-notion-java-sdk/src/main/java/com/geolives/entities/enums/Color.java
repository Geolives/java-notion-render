package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.ColorConstants;

public enum Color {
    DEFAULT(ColorConstants.DEFAULT),
    BLUE(ColorConstants.BLUE),
    BLUE_BACKGROUND(ColorConstants.BLUE_BACKGROUND),
    BROWN(ColorConstants.BROWN),
    BROWN_BACKGROUND(ColorConstants.BROWN_BACKGROUND),
    GRAY(ColorConstants.GRAY),
    GRAY_BACKGROUND(ColorConstants.GRAY_BACKGROUND),
    GREEN(ColorConstants.GREEN),
    GREEN_BACKGROUND(ColorConstants.GREEN_BACKGROUND),
    ORANGE(ColorConstants.ORANGE),
    ORANGE_BACKGROUND(ColorConstants.ORANGE_BACKGROUND),
    PINK(ColorConstants.PINK),
    PINK_BACKGROUND(ColorConstants.PINK_BACKGROUND),
    PURPLE(ColorConstants.PURPLE),
    PURPLE_BACKGROUND(ColorConstants.PURPLE_BACKGROUND),
    RED(ColorConstants.RED),
    RED_BACKGROUND(ColorConstants.RED_BACKGROUND),
    YELLOW(ColorConstants.YELLOW),
    YELLOW_BACKGROUND(ColorConstants.YELLOW_BACKGROUND);

    private final String value;

    Color(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static Color fromValue(String value) {
        for (Color type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
