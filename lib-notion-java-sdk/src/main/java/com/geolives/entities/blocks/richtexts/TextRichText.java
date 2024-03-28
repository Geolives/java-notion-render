package com.geolives.entities.blocks.richtexts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.RichTextType;

import java.util.Optional;

public class TextRichText extends RichText {
    private Text text;

    public TextRichText() {
        super(RichTextType.TEXT);
    }
    @JsonIgnore()
    public String getContent() {
        return this.text.getContent();
    }
    @JsonIgnore()
    public void setContent(final String content) {
        this.text.content = content;
    }
    @JsonIgnore()
    public String getLinkUrl() {
        if(this.text.link == null) {
            return null;
        } else {
            return this.text.link.getUrl();
        }
    }
    @JsonIgnore()
    public void setLinkUrl(final String url) {
        if(this.text.link == null) {
            this.text.link = new Text().new Link();
        }
        this.text.link.setUrl(url);
    }

    public Text getText() {
        return this.text;
    }

    public void setText(final Text text) {
        this.text = text;
    }

    private class Text {
        private String content;
        private Link link;

        public Text() {}

        public String getContent() {
            return this.content;
        }

        public void setContent(final String content) {
            this.content = content;
        }

        public Link getLink() {
            return this.link;
        }

        public void setLink(final Link link) {
            this.link = link;
        }

        private class Link {
            private String url;

            public Link() {}

            public String getUrl() {
                return this.url;
            }

            public void setUrl(final String url) {
                this.url = url;
            }
        }
    }
}
