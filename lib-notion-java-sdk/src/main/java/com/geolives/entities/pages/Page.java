package com.geolives.entities.pages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.users.User;
import com.geolives.entities.files.File;
import com.geolives.entities.icons.Icon;
import com.geolives.entities.parents.Parent;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Page {
    private String object;
    private String id;
    private ZonedDateTime createdTime;
    private ZonedDateTime  lastEditedTime;
    private User createdBy;
    private User lastEditedBy;
    private boolean archived;
    private Icon icon;
    private File cover;
    private Parent parent;
    private String url;
    private String publicUrl;
    private PageProperties properties;
    private List<Block> children = new ArrayList<>();

    private List<BreadcrumbItem> breadcrumb;

    public Page() {}

    public String getObject() {
        return this.object;
    }

    public void setObject(final String object) {
        this.object = object;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(final ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getLastEditedTime() {
        return this.lastEditedTime;
    }

    public void setLastEditedTime(final ZonedDateTime lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(final User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastEditedBy() {
        return this.lastEditedBy;
    }

    public void setLastEditedBy(final User lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public boolean isArchived() {
        return this.archived;
    }

    public void setArchived(final boolean archived) {
        this.archived = archived;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setIcon(final Icon icon) {
        this.icon = icon;
    }

    public File getCover() {
        return this.cover;
    }

    public void setCover(final File cover) {
        this.cover = cover;
    }

    public Parent getParent() {
        return this.parent;
    }

    public void setParent(final Parent parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getPublicUrl() {
        return this.publicUrl;
    }

    public void setPublicUrl(final String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public PageProperties getProperties() {
        return this.properties;
    }

    public void setProperties(final PageProperties properties) {
        this.properties = properties;
    }

    public List<Block> getChildren() {
        return this.children;
    }

    public void setChildren(final List<Block> children) {
        this.children = children;
    }

    public void addChildren(final List<Block> children) {
        this.children.addAll(children);
    }

    public List<BreadcrumbItem> getBreadcrumb() {
        return this.breadcrumb;
    }

    public void setBreadcrumb(final List<BreadcrumbItem> breadcrumb) {
        this.breadcrumb = breadcrumb;
    }
    @JsonIgnore()
    public String getRawTitle() {
        StringBuilder rawTitle = new StringBuilder();
        for(RichText richText : this.properties.getTitle().getTitle()) {
            rawTitle.append(richText.getPlainText());
        }
        return rawTitle.toString();
    }
    @JsonIgnore()
    public List<Block> getChildrenList() {
        return this.children.stream()
                .flatMap(Block::flatten)
                .collect(Collectors.toList());
    }

    @JsonIgnore()
    public Map<String, Block> getChildrenMap() {
        return getChildrenList().stream()
                .collect(Collectors.toMap(Block::getId, block -> block));
    }
}
