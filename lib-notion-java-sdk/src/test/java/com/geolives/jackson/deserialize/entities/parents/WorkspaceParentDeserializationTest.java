package com.geolives.jackson.deserialize.entities.parents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.enums.ParentType;
import com.geolives.entities.parents.WorkspaceParent;
import com.geolives.utils.NotionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkspaceParentDeserializationTest {
    private final ObjectMapper objectMapper = NotionUtils.getNotionMapper();

    @Test
    void deserializeWorkspaceParent() throws Exception {
        String json = "{\n" +
                "\t\"type\": \"workspace\",\n" +
                "\t\"workspace\": true\n" +
                "}";
        WorkspaceParent result = objectMapper.readValue(json, WorkspaceParent.class);
        assertTrue(result.isRoot());
        assertEquals(ParentType.WORKSPACE, result.getType());
    }

}