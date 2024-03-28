package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

public class QuoteBlock extends Block{
    private Quote quote;

    public QuoteBlock() {
        super(BlockType.QUOTE);
    }

    public Quote getQuote() {
        return this.quote;
    }

    public void setQuote(final Quote quote) {
        this.quote = quote;
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.quote.getRichText();
    }
    @JsonIgnore()
    public void setRichTexts(final RichText[] richTexts) {
        this.quote.setRichText(richTexts);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.quote.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.quote.setColor(color);
    }

    private class Quote {
        private RichText[] richText;
        private Color color;

        public Quote() {}

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
