package com.geolives.entities.pages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;

public class PageProperties {
    private Title title;

    public PageProperties() {}

    public Title getTitle() {
        return this.title;
    }

    public void setTitle(final Title title) {
        this.title = title;
    }
    @JsonIgnore()
    public RichText[] getRichTextsTitle() {
        return this.title.getTitle();
    }
    @JsonIgnore()
    public void setRichTextsTitle(final RichText[] richTexts) {
        this.title.setTitle(richTexts);
    }


    public class Title {
        private RichText[] title;

        public Title() {}

        public RichText[] getTitle() {
            return this.title;
        }

        public void setTitle(final RichText[] title) {
            this.title = title;
        }
    }
}
