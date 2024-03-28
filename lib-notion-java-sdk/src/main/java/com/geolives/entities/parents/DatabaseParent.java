package com.geolives.entities.parents;

import com.geolives.entities.enums.ParentType;

public class DatabaseParent extends Parent {
    private String databaseId;

    public DatabaseParent() {
        super(ParentType.DATABASEID);
    }

    public DatabaseParent(final String databaseId) {
        super(ParentType.DATABASEID);
        this.databaseId = databaseId;
    }

    public String getDatabaseId() {
        return this.databaseId;
    }

    public void setDatabaseId(final String databaseId) {
        this.databaseId = databaseId;
    }
}
