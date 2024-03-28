package com.geolives.entities.parents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.enums.constants.BlockTypeConstants;
import com.geolives.entities.enums.constants.ParentTypeConstants;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BlockParent.class, name = ParentTypeConstants.BLOCK),
        @JsonSubTypes.Type(value = DatabaseParent.class, name = ParentTypeConstants.DATABASE),
        @JsonSubTypes.Type(value = PageParent.class, name = ParentTypeConstants.PAGE),
        @JsonSubTypes.Type(value = WorkspaceParent.class, name = ParentTypeConstants.WORKSPACE)
})
public abstract class Parent {
    @JsonIgnore()
    private ParentType type;

    public Parent() {}
    public Parent(final ParentType type) {
        this.type = type;
    }

    public ParentType getType() {
        return this.type;
    }

    public void setType(final ParentType type) {
        this.type = type;
    }
}
