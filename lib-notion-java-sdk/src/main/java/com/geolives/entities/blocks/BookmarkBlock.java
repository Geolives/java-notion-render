package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.enums.BlockType;

public class BookmarkBlock extends Block {
    private Bookmark bookmark;

    public BookmarkBlock() {
        super(BlockType.BOOKMARK);
    }
    @JsonIgnore()
    public RichText[] getCaption() {
        return this.bookmark.getCaption();
    }
    @JsonIgnore()
    public void setCaption(final RichText[] caption) {
        this.bookmark.setCaption(caption);
    }
    @JsonIgnore()
    public String getUrl() {
        return this.bookmark.getUrl();
    }
    @JsonIgnore()
    public void setUrl(final String url) {
        this.bookmark.setUrl(url);
    }

    public Bookmark getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(final Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    private class Bookmark {

        private RichText[] caption;
        private String url;

        public Bookmark() {}

        public RichText[] getCaption() {
            return this.caption;
        }

        public void setCaption(final RichText[] caption) {
            this.caption = caption;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(final String url) {
            this.url = url;
        }
    }
}
