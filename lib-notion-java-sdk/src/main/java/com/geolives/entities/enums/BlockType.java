package com.geolives.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.geolives.entities.enums.constants.BlockTypeConstants;


public enum BlockType {
    BOOKMARK(BlockTypeConstants.BOOKMARK),
    BREADCRUMB(BlockTypeConstants.BREADCRUMB),
    BULLETED_LIST_ITEM(BlockTypeConstants.BULLETED_LIST_ITEM),
    CALLOUT(BlockTypeConstants.CALLOUT),
    CHILD_DATABASE(BlockTypeConstants.CHILD_DATABASE),
    CHILD_PAGE(BlockTypeConstants.CHILD_PAGE),
    COLUMN(BlockTypeConstants.COLUMN),
    COLUMN_LIST(BlockTypeConstants.COLUMN_LIST),
    DIVIDER(BlockTypeConstants.DIVIDER),
    EMBED(BlockTypeConstants.EMBED),
    EQUATION(BlockTypeConstants.EQUATION),
    FILE(BlockTypeConstants.FILE),
    HEADING_1(BlockTypeConstants.HEADING_1),
    HEADING_2(BlockTypeConstants.HEADING_2),
    HEADING_3(BlockTypeConstants.HEADING_3),
    IMAGE(BlockTypeConstants.IMAGE),
    LINK_PREVIEW(BlockTypeConstants.LINK_PREVIEW),
    LINK_TO_PAGE(BlockTypeConstants.LINK_TO_PAGE),
    NUMBERED_LIST_ITEM(BlockTypeConstants.NUMBERED_LIST_ITEM),
    PARAGRAPH(BlockTypeConstants.PARAGRAPH),
    PDF(BlockTypeConstants.PDF),
    QUOTE(BlockTypeConstants.QUOTE),
    SYNCED_BLOCK(BlockTypeConstants.SYNCED_BLOCK),
    TABLE(BlockTypeConstants.TABLE),
    TABLE_OF_CONTENTS(BlockTypeConstants.TABLE_OF_CONTENTS),
    TABLE_ROW(BlockTypeConstants.TABLE_ROW),
    TEMPLATE(BlockTypeConstants.TEMPLATE),
    TO_DO(BlockTypeConstants.TO_DO),
    TOGGLE(BlockTypeConstants.TOGGLE),
    UNSUPPORTED(BlockTypeConstants.UNSUPPORTED),
    VIDEO(BlockTypeConstants.VIDEO);

    private final String value;

    BlockType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static BlockType fromValue(String value) {
        for (BlockType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
