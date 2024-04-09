package com.geolives.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.parents.Parent;
import com.geolives.entities.users.User;

import java.time.ZonedDateTime;

public class Comment {
    private String id;
    private Parent parent;
    private String discussionId;
    private ZonedDateTime createdTime;
    private ZonedDateTime  lastEditedTime;
    private User createdBy;
    private RichText[] richText;

    public Comment() {}

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Parent getParent() {
        return this.parent;
    }

    public void setParent(final Parent parent) {
        this.parent = parent;
    }

    public String getDiscussionId() {
        return this.discussionId;
    }

    public void setDiscussionId(final String discussionId) {
        this.discussionId = discussionId;
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

    public RichText[] getRichText() {
        return this.richText;
    }

    public void setRichText(final RichText[] richText) {
        this.richText = richText;
    }

    public RichText[] getRichTexts() {
        return this.getRichText();
    }

    public void setRichTexts(final RichText[] richTexts) {
        this.setRichText(richTexts);
    }

    @JsonIgnore
    public String getRawContent() {
        final StringBuilder stringBuilder = new StringBuilder();
        for(RichText richText : this.richText) {
            stringBuilder.append(richText.getPlainText());
        }
        return stringBuilder.toString();
    }
}
