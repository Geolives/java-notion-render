package com.geolives.entities.parents;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.enums.constants.ParentTypeConstants;

public class BlockParent extends Parent {
    private String blockId;

    public BlockParent() {
        super(ParentType.BLOCK);
    }

    public BlockParent(final String blockId) {
        super(ParentType.BLOCK);
        this.blockId = blockId;
    }

    public String getBlockId() {
        return this.blockId;
    }

    public void setBlockId(final String blockId) {
        this.blockId = blockId;
    }
}
