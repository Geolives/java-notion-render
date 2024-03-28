package com.geolives.entities.parents;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.enums.constants.ParentTypeConstants;

public class WorkspaceParent extends Parent {
    @JsonProperty(ParentTypeConstants.WORKSPACE)
    private boolean isRoot;

    public WorkspaceParent() {
        super(ParentType.WORKSPACE);
    }

    public WorkspaceParent(final boolean isRoot) {
        super(ParentType.WORKSPACE);
        this.isRoot = isRoot;
    }

    public boolean isRoot() {
        return this.isRoot;
    }

    public void setRoot(final boolean root) {
        isRoot = root;
    }
}
