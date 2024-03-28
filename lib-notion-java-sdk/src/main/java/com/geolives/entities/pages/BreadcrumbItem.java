package com.geolives.entities.pages;

public class BreadcrumbItem {
    private String title;
    private String id;

    public BreadcrumbItem(final String title, final String id) {
        this.title = title;
        this.id = id;
    }

    public BreadcrumbItem() {}

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }
}
