package com.geolives.entities.blocks.headings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Heading1Block extends Block {
    @JsonProperty("heading_1")
    private HeadingProperties heading1;

    public Heading1Block() {
        super(BlockType.HEADING_1);
    }

    public HeadingProperties getHeading1() {
        return this.heading1;
    }

    public void setHeading1(final HeadingProperties heading1) {
        this.heading1 = heading1;
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.heading1.getRichText();
    }
    @JsonIgnore()
    public void setRichText(final RichText[] richText) {
        this.heading1.setRichText(richText);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.heading1.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.heading1.setColor(color);
    }
    @JsonIgnore()
    public boolean isToggleable() {
        return this.heading1.isToggleable();
    }
    @JsonIgnore()
    public void setToggleable(final boolean toggleable) {
        this.heading1.setToggleable(toggleable);
    }
}
