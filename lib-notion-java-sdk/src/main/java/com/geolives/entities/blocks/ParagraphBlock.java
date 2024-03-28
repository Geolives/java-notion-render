package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

public class ParagraphBlock extends Block{
    private Paragraph paragraph;

    public ParagraphBlock() {
        super(BlockType.PARAGRAPH);
    }

    public Paragraph getParagraph() {
        return this.paragraph;
    }

    public void setParagraph(final Paragraph paragraph) {
        this.paragraph = paragraph;
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.paragraph.getRichText();
    }
    @JsonIgnore()
    public void setRichTexts(final RichText[] richTexts) {
        this.paragraph.setRichText(richTexts);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.paragraph.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.paragraph.setColor(color);
    }

    private class Paragraph {
        private RichText[] richText;
        private Color color;

        public Paragraph() {}

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
