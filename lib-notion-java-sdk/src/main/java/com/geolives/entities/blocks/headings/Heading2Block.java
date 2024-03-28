package com.geolives.entities.blocks.headings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Heading2Block extends Block {
    @JsonProperty("heading_2")
    private HeadingProperties heading2;

    public Heading2Block() {
        super(BlockType.HEADING_2);
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.heading2.getRichText();
    }
    @JsonIgnore()
    public void setRichText(final RichText[] richText) {
        this.heading2.setRichText(richText);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.heading2.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.heading2.setColor(color);
    }
    @JsonIgnore()
    public boolean isToggleable() {
        return this.heading2.isToggleable();
    }
    @JsonIgnore()
    public void setToggleable(final boolean toggleable) {
        this.heading2.setToggleable(toggleable);
    }

    public HeadingProperties getHeading2() {
        return this.heading2;
    }

    public void setHeading2(final HeadingProperties heading2) {
        this.heading2 = heading2;
    }
}
