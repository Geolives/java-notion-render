package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

public class BulletedListItemBlock extends Block {

    private BulletedListItem bulletedListItem;

    public BulletedListItemBlock() {
        super(BlockType.BULLETED_LIST_ITEM);
    }

    public BulletedListItem getBulletedListItem() {
        return this.bulletedListItem;
    }

    public void setBulletedListItem(final BulletedListItem bulletedListItem) {
        this.bulletedListItem = bulletedListItem;
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.bulletedListItem.getRichText();
    }
    @JsonIgnore()
    public void setRichTexts(final RichText[] richTexts) {
        this.bulletedListItem.setRichText(richTexts);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.bulletedListItem.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.bulletedListItem.setColor(color);
    }

    private class BulletedListItem {
        private RichText[] richText;
        private Color color;

        public BulletedListItem() {}

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
