package com.geolives.entities.blocks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geolives.entities.users.User;
import com.geolives.entities.blocks.headings.*;
import com.geolives.entities.enums.BlockType;
import com.geolives.entities.enums.constants.BlockTypeConstants;
import com.geolives.entities.parents.Parent;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BookmarkBlock.class, name = BlockTypeConstants.BOOKMARK),
        @JsonSubTypes.Type(value = BreadcrumbBlock.class, name = BlockTypeConstants.BREADCRUMB),
        @JsonSubTypes.Type(value = BulletedListItemBlock.class, name = BlockTypeConstants.BULLETED_LIST_ITEM),
        @JsonSubTypes.Type(value = CalloutBlock.class, name = BlockTypeConstants.CALLOUT),
        @JsonSubTypes.Type(value = ChildPageBlock.class, name = BlockTypeConstants.CHILD_PAGE),
        @JsonSubTypes.Type(value = ColumnListBlock.class, name = BlockTypeConstants.COLUMN_LIST),
        @JsonSubTypes.Type(value = ColumnBlock.class, name = BlockTypeConstants.COLUMN),
        @JsonSubTypes.Type(value = Heading1Block.class, name = BlockTypeConstants.HEADING_1),
        @JsonSubTypes.Type(value = Heading2Block.class, name = BlockTypeConstants.HEADING_2),
        @JsonSubTypes.Type(value = Heading3Block.class, name = BlockTypeConstants.HEADING_3),
        @JsonSubTypes.Type(value = ImageBlock.class, name = BlockTypeConstants.IMAGE),
        @JsonSubTypes.Type(value = NumberedListItemBlock.class, name = BlockTypeConstants.NUMBERED_LIST_ITEM),
        @JsonSubTypes.Type(value = ParagraphBlock.class, name = BlockTypeConstants.PARAGRAPH),
        @JsonSubTypes.Type(value = QuoteBlock.class, name = BlockTypeConstants.QUOTE),

        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.CHILD_DATABASE),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.DIVIDER),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.EMBED),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.EQUATION),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.FILE),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.LINK_PREVIEW),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.LINK_TO_PAGE),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.PDF),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.SYNCED_BLOCK),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.TABLE),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.TABLE_OF_CONTENTS),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.TABLE_ROW),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.TEMPLATE),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.TO_DO),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.TOGGLE),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.VIDEO),
        @JsonSubTypes.Type(value = UnsupportedBlock.class, name = BlockTypeConstants.UNSUPPORTED)
})
public abstract class Block {
    private String object;
    private String id;
    private Parent parent;
    private ZonedDateTime  createdTime;
    private ZonedDateTime  lastEditedTime;
    private User createdBy;
    private User lastEditedBy;
    private boolean hasChildren;
    private boolean archived;
    @JsonIgnore()
    private BlockType type;

    private List<Block> children = new ArrayList<>();

    public Block() {}

    public Block(final BlockType type) {
        this.type = type;
    }

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

    public Parent getParent() {
        return this.parent;
    }

    public void setParent(final Parent parent) {
        this.parent = parent;
    }

    public ZonedDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(final ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime  getLastEditedTime() {
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
    @JsonProperty("has_children")
    public boolean hasChildren() {
        return this.hasChildren;
    }

    public void setHasChildren(final boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public boolean isArchived() {
        return this.archived;
    }

    public void setArchived(final boolean archived) {
        this.archived = archived;
    }

    public BlockType getType() {
        return this.type;
    }

    public void setType(final BlockType type) {
        this.type = type;
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
    @JsonIgnore()
    public Stream<Block> flatten() {
        return Stream.concat(Stream.of(this),
                children.stream().flatMap(Block::flatten));
    }

}
