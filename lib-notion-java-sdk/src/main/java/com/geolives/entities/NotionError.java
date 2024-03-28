package com.geolives.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NotionError {
    private int status;
    private String code;
    private String message;
    private String requestId;

    public NotionError() {}

    public NotionError(final int status, final String code, final String message, final String requestId) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.requestId = requestId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }
    @JsonIgnore()
    @Override
    public String toString() {
        return String.format("Error Status Code: %s\nError Name Code: %s\nError Message: %s\nRequest ID: %s", this.status, this.code, this.message, this.requestId);
    }
}
