package com.geolives.entities;

import com.geolives.entities.blocks.Block;

import java.util.List;

public class NotionResponse {
    private List<Block> results;
    private String nextCursor;
    private boolean hasMore;
    private String requestId;

    public NotionResponse() {}

    public List<Block> getResults() {
        return this.results;
    }

    public void setResults(final List<Block> results) {
        this.results = results;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public void setNextCursor(final String nextCursor) {
        this.nextCursor = nextCursor;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(final boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }
}
