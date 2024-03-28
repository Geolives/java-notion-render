package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.BlockType;

public class ChildPageBlock extends Block{
    private ChildPage childPage;

    public ChildPageBlock() {
        super(BlockType.CHILD_PAGE);
    }

    public ChildPage getChildPage() {
        return this.childPage;
    }
    @JsonIgnore()
    public String getTitle() {
        return this.childPage.getTitle();
    }
    @JsonIgnore()
    public void setTitle(final String title) {
        this.childPage.setTitle(title);
    }

    public void setChildPage(final ChildPage childPage) {
        this.childPage = childPage;
    }

    private class ChildPage {
        private String title;

        public ChildPage() {}

        public String getTitle() {
            return this.title;
        }

        public void setTitle(final String title) {
            this.title = title;
        }
    }
}
