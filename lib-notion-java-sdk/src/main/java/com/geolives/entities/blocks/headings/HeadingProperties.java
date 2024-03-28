package com.geolives.entities.blocks.headings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.Color;

public class HeadingProperties {
    private RichText[] richText;
    private Color color;
    private boolean isToggleable;

    public HeadingProperties() {}

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
    @JsonProperty("is_toggleable")
    public boolean isToggleable() {
        return this.isToggleable;
    }

    public void setToggleable(final boolean toggleable) {
        this.isToggleable = toggleable;
    }
}
