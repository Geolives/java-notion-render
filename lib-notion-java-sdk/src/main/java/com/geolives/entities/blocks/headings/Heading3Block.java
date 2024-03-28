package com.geolives.entities.blocks.headings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Heading3Block extends Block {
    @JsonProperty("heading_3")
    private HeadingProperties heading3;

    public Heading3Block() {
        super(BlockType.HEADING_3);
    }
    @JsonIgnore()
    public RichText[] getRichTexts() {
        return this.heading3.getRichText();
    }
    @JsonIgnore()
    public void setRichText(final RichText[] richText) {
        this.heading3.setRichText(richText);
    }
    @JsonIgnore()
    public Color getColor() {
        return this.heading3.getColor();
    }
    @JsonIgnore()
    public void setColor(final Color color) {
        this.heading3.setColor(color);
    }
    @JsonIgnore()
    public boolean isToggleable() {
        return this.heading3.isToggleable();
    }
    @JsonIgnore()
    public void setToggleable(final boolean toggleable) {
        this.heading3.setToggleable(toggleable);
    }

    public HeadingProperties getHeading3() {
        return this.heading3;
    }

    public void setHeading3(final HeadingProperties heading3) {
        this.heading3 = heading3;
    }
}
