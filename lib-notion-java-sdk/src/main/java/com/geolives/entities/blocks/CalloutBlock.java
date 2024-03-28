package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;
import com.geolives.entities.icons.Icon;

public class CalloutBlock extends Block {
    private Callout callout;

    public CalloutBlock() {
        super(BlockType.CALLOUT);
    }

    public Callout getCallout() {
        return this.callout;
    }

    public void setCallout(final Callout callout) {
        this.callout = callout;
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.callout.getRichText();
    }
    @JsonIgnore()
    public void setRichTexts(final RichText[] richTexts) {
        this.callout.setRichText(richTexts);
    }
    @JsonIgnore()
    public Icon getIcon() {
        return this.callout.getIcon();
    }
    @JsonIgnore()
    public void setIcon(final Icon icon) {
        this.callout.setIcon(icon);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.callout.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.callout.setColor(color);
    }

    private class Callout {
        private RichText[] richText;
        private Icon icon;
        private Color color;



        public Callout() {}

        public RichText[] getRichText() {
            return richText;
        }

        public void setRichText(final RichText[] richText) {
            this.richText = richText;
        }

        public Icon getIcon() {
            return this.icon;
        }

        public void setIcon(final Icon icon) {
            this.icon = icon;
        }

        public Color getColor() {
            return this.color;
        }

        public void setColor(final Color color) {
            this.color = color;
        }
    }
}
