package com.geolives.entities.parents;

import com.geolives.entities.enums.ParentType;

public class PageParent extends Parent {
    private String pageId;

    public PageParent(){
        super(ParentType.PAGE);
    }

    public PageParent(final String pageId) {
        super(ParentType.PAGE);
        this.pageId = pageId;
    }

    public String getPageId() {
        return this.pageId;
    }

    public void setPageId(final String pageId) {
        this.pageId = pageId;
    }
}
