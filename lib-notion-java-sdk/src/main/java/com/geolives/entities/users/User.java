package com.geolives.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.UserType;

public class User {
    private String id;
    private UserType type;
    private String name;
    private String avatarUrl;

    public User() {}

    public UserType getType() {
        return this.type;
    }

    public void setType(final UserType type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(final String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
