package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

public class NumberedListItemBlock extends Block {
    private NumberedListItem numberedListItem;

    public NumberedListItemBlock() {
        super(BlockType.NUMBERED_LIST_ITEM);
    }

    public NumberedListItem getNumberedListItem() {
        return this.numberedListItem;
    }

    public void setNumberedListItem(final NumberedListItem numberedListItem) {
        this.numberedListItem = numberedListItem;
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.numberedListItem.getRichText();
    }
    @JsonIgnore()
    public void setRichTexts(final RichText[] richTexts) {
        this.numberedListItem.setRichText(richTexts);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.numberedListItem.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.numberedListItem.setColor(color);
    }

    private class NumberedListItem {
        private RichText[] richText;
        private Color color;

        public NumberedListItem() {}

        public RichText[] getRichText() {
            return this.richText;
        }

        public void setRichText(final RichText[] richText) {
            this.richText = richText;
        }

        public Color getColor() {
            return this.color;
        }

        public void setColor(final Color color) {
            this.color = color;
        }
    }
}
