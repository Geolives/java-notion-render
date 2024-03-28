package com.geolives.entities.blocks.richtexts;

import com.geolives.entities.enums.Color;

public class Annotation {
    private boolean bold;
    private boolean italic;
    private boolean strikethrough;
    private boolean underline;
    private boolean code;
    private Color color;

    public Annotation() {}

    public boolean isBold() {
        return this.bold;
    }

    public void setBold(final boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return this.italic;
    }

    public void setItalic(final boolean italic) {
        this.italic = italic;
    }

    public boolean isStrikethrough() {
        return this.strikethrough;
    }

    public void setStrikethrough(final boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    public boolean isUnderline() {
        return this.underline;
    }

    public void setUnderline(final boolean underline) {
        this.underline = underline;
    }

    public boolean isCode() {
        return this.code;
    }

    public void setCode(final boolean code) {
        this.code = code;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }
}
