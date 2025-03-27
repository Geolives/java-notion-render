package units.jackson.deserialize.entities.blocks;

import com.geolives.entities.enums.constants.BlockTypeConstants;

public class BlockJsonBuilder {

    public static String getTextRichTextJsonWithNullLink(final String content) {
        return  String.format("{\n" +
                "\t\t\t\t\"type\": \"text\",\n" +
                "\t\t\t\t\"text\": {\n" +
                "\t\t\t\t\t\"content\": \"%s\",\n" +
                "\t\t\t\t\t\"link\": null\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"annotations\": {\n" +
                "\t\t\t\t\t\"bold\": false,\n" +
                "\t\t\t\t\t\"italic\": false,\n" +
                "\t\t\t\t\t\"strikethrough\": false,\n" +
                "\t\t\t\t\t\"underline\": false,\n" +
                "\t\t\t\t\t\"code\": false,\n" +
                "\t\t\t\t\t\"color\": \"green\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"plain_text\": \"Lacinato kale\",\n" +
                "\t\t\t\t\"href\": null\n" +
                "\t\t\t}", content) ;
    }

    public static String getTextRichTextJsonWithLink(final String content, final String url) {
        return  String.format("{\n" +
                "  \"type\": \"text\",\n" +
                "  \"text\": {\n" +
                "    \"content\": \"%s\",\n" +
                "    \"link\": {\n" +
                "      \"url\": \"%s\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"annotations\": {\n" +
                "    \"bold\": false,\n" +
                "    \"italic\": false,\n" +
                "    \"strikethrough\": false,\n" +
                "    \"underline\": false,\n" +
                "    \"code\": false,\n" +
                "    \"color\": \"default\"\n" +
                "  },\n" +
                "  \"plain_text\": \"inline link\",\n" +
                "  \"href\": \"https://developers.notion.com/\"\n" +
                "}", content, url);
    }

    private static String getBlockJson(final String type, final String typeObject) {
        return String.format("{\n" +
                "\t\"object\": \"block\",\n" +
                "\t\"id\": \"c02fc1d3-db8b-45c5-a222-27595b15aea7\",\n" +
                "\t\"parent\": {\n" +
                "\t\t\"type\": \"page_id\",\n" +
                "\t\t\"page_id\": \"59833787-2cf9-4fdf-8782-e53db20768a5\"\n" +
                "\t},\n" +
                "\t\"created_time\": \"2022-03-01T19:05:00.000Z\",\n" +
                "\t\"last_edited_time\": \"2022-07-06T19:41:00.000Z\",\n" +
                "\t\"created_by\": {\n" +
                "\t\t\"object\": \"user\",\n" +
                "\t\t\"id\": \"ee5f0f84-409a-440f-983a-a5315961c6e4\"\n" +
                "\t},\n" +
                "\t\"last_edited_by\": {\n" +
                "\t\t\"object\": \"user\",\n" +
                "\t\t\"id\": \"ee5f0f84-409a-440f-983a-a5315961c6e4\"\n" +
                "\t},\n" +
                "\t\"has_children\": false,\n" +
                "\t\"archived\": false,\n" +
                "\t\"type\": \"%s\"," +
                "\t%s" +
                "}", type, typeObject);

    }

    public static String getBookmarkBlockJson() {
        return getBlockJson(BlockTypeConstants.BOOKMARK, "\"bookmark\": {\n" +
                "    \"caption\": [],\n" +
                "    \"url\": \"https://companywebsite.com\"\n" +
                "  }");
    }

    public static String getBreadcrumbBlockJson() {
        return getBlockJson(BlockTypeConstants.BREADCRUMB, "\"breadcrumb\": {}");
    }

    public static String getBulletedListItemBlockJson() {
        return getBlockJson(BlockTypeConstants.BULLETED_LIST_ITEM, "\"bulleted_list_item\": {" +
                "\"rich_text\": [{" +
                "\"type\": \"text\"," +
                "\"text\": {" +
                "\"content\": \"Liste puce 1\"," +
                "\"link\": null" +
                "}," +
                "\"annotations\": {" +
                "\"bold\": false," +
                "\"italic\": false," +
                "\"strikethrough\": false," +
                "\"underline\": false," +
                "\"code\": false," +
                "\"color\": \"default\"" +
                "}," +
                "\"plain_text\": \"Liste puce 1\"," +
                "\"href\": null" +
                "}]," +
                "\"color\": \"default\"" +
                "}");
    }

    public static String getChildPageBlock() {
        return getBlockJson(BlockTypeConstants.CHILD_PAGE, "\"child_page\": {\n" +
                "    \"title\": \"Lacinato kale\"\n" +
                "  }");
    }

    public static String getColumnListBlock() {
        return getBlockJson(BlockTypeConstants.COLUMN_LIST, "\"column_list\": {}");
    }
    public static String getColumnBlock() {
        return getBlockJson(BlockTypeConstants.COLUMN, "\"column\": {}");
    }

    public static String getHeading1Block() {
        return getBlockJson(BlockTypeConstants.HEADING_1, "\"heading_1\": {\n" +
                "    \"rich_text\": [{\n" +
                "      \"type\": \"text\",\n" +
                "      \"text\": {\n" +
                "        \"content\": \"Lacinato kale\",\n" +
                "        \"link\": null\n" +
                "      }\n" +
                "    }],\n" +
                "    \"color\": \"default\",\n" +
                "    \"is_toggleable\": false\n" +
                "  }");
    }
    public static String getHeading2Block() {
        return getBlockJson(BlockTypeConstants.HEADING_2, "\"heading_2\": {\n" +
                "    \"rich_text\": [{\n" +
                "      \"type\": \"text\",\n" +
                "      \"text\": {\n" +
                "        \"content\": \"Lacinato kale\",\n" +
                "        \"link\": null\n" +
                "      }\n" +
                "    }],\n" +
                "    \"color\": \"default\",\n" +
                "    \"is_toggleable\": false\n" +
                "  }");
    }
    public static String getHeading3Block() {
        return getBlockJson(BlockTypeConstants.HEADING_3, "\"heading_3\": {\n" +
                "    \"rich_text\": [{\n" +
                "      \"type\": \"text\",\n" +
                "      \"text\": {\n" +
                "        \"content\": \"Lacinato kale\",\n" +
                "        \"link\": null\n" +
                "      }\n" +
                "    }],\n" +
                "    \"color\": \"default\",\n" +
                "    \"is_toggleable\": false\n" +
                "  }");
    }

    public static String getExternalImageBlock() {
        return getBlockJson(BlockTypeConstants.IMAGE, "\"image\": {\n" +
                "    \"type\": \"external\",\n" +
                "    \"external\": {\n" +
                " \t  \t\"url\": \"https://website.domain/images/image.png\"\n" +
                "    }\n" +
                "  }");
    }

    public static String getInternalImageBlock() {
        return getBlockJson(BlockTypeConstants.IMAGE, "\"image\": {\n" +
                "    \"type\": \"file\",\n" +
                "    \"file\": {\n" +
                " \t  \t\"url\": \"https://website.domain/images/image.png\"\n" +
                "    }\n" +
                "  }");
    }

    public static String getNumberedListItemBlock() {
        return getBlockJson(BlockTypeConstants.NUMBERED_LIST_ITEM, "\"numbered_list_item\": {\n" +
                "    \"rich_text\": [\n" +
                "      {\n" +
                "        \"type\": \"text\",\n" +
                "        \"text\": {\n" +
                "          \"content\": \"Finish reading the docs\",\n" +
                "          \"link\": null\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"color\": \"default\"\n" +
                "  }");
    }

    public static String getCalloutBlock() {
        return getBlockJson(BlockTypeConstants.CALLOUT, "\"callout\": {\n" +
                "   \t\"rich_text\": [],\n" +
                "     \"icon\": {\n" +
                "       \"type\": \"emoji\"," +
                "       \"emoji\": \"aaaa\"\n" +
                "     },\n" +
                "     \"color\": \"default\"\n" +
                "   }");
    }

    public static String getTableBlock() {
        return getBlockJson(BlockTypeConstants.TABLE, "\"table\": {\n" +
                "   \t\"table_width\": 2,\n" +
                "   \t\"has_column_header\": false,\n" +
                "   \t\"has_row_header\": false\n" +
                "}");
    }

    public static String getTableRowBlock() {
        return getBlockJson(BlockTypeConstants.TABLE_ROW, "\"table_row\": {\n" +
                "\t\"cells\": \n" +
                "[[" + getTextRichTextJsonWithNullLink("Test") + "]]\n" +
                "}");
    }

    public static String getParagraphBlock() {
        return getBlockJson(BlockTypeConstants.PARAGRAPH, "\"paragraph\": {\n" +
                "    \"rich_text\": [{\n" +
                "      \"type\": \"text\",\n" +
                "      \"text\": {\n" +
                "        \"content\": \"Lacinato kale\",\n" +
                "        \"link\": null\n" +
                "      }\n" +
                "    }],\n" +
                "    \"color\": \"default\"\n" +
                "}");
    }

    public static String getQuoteBlock() {
        return getBlockJson(BlockTypeConstants.QUOTE, "\"quote\": {\n" +
                "    \"rich_text\": [],\n" +
                "    \"color\": \"default\"\n" +
                "}\n");
    }

    public static String getUnsupportedBlock() {
        return "{\"type\": \""+BlockTypeConstants.UNSUPPORTED+"\"}";
    }

    public static String getPage() {
        return "{\n" +
                "    \"object\": \"page\",\n" +
                "    \"id\": \"f5517d7e-c742-46ba-87ed-0c012b34bf2f\",\n" +
                "    \"created_time\": \"2021-04-28T08:35:00.000Z\",\n" +
                "    \"last_edited_time\": \"2024-02-15T09:24:00.000Z\",\n" +
                "    \"created_by\": {\n" +
                "        \"object\": \"user\",\n" +
                "        \"id\": \"dac07695-f684-4a5d-b178-253aac4aa03b\"\n" +
                "    },\n" +
                "    \"last_edited_by\": {\n" +
                "        \"object\": \"user\",\n" +
                "        \"id\": \"061e6734-223f-4e62-abab-d8c9cf9f43f6\"\n" +
                "    },\n" +
                "    \"cover\": null,\n" +
                "    \"icon\": {\n" +
                "        \"type\": \"emoji\",\n" +
                "        \"emoji\": \"?\"\n" +
                "    },\n" +
                "    \"parent\": {\n" +
                "        \"type\": \"page_id\",\n" +
                "        \"page_id\": \"1025d8ae-fb1d-459c-acd8-1853f201d9c8\"\n" +
                "    },\n" +
                "    \"archived\": false,\n" +
                "    \"properties\": {\n" +
                "        \"title\": {\n" +
                "            \"id\": \"title\",\n" +
                "            \"type\": \"title\",\n" +
                "            \"title\": [{\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"text\": {\n" +
                "                        \"content\": \"Aide en ligne SityTrail FR\",\n" +
                "                        \"link\": null\n" +
                "                    },\n" +
                "                    \"annotations\": {\n" +
                "                        \"bold\": false,\n" +
                "                        \"italic\": false,\n" +
                "                        \"strikethrough\": false,\n" +
                "                        \"underline\": false,\n" +
                "                        \"code\": false,\n" +
                "                        \"color\": \"default\"\n" +
                "                    },\n" +
                "                    \"plain_text\": \"Aide en ligne SityTrail FR\",\n" +
                "                    \"href\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"url\": \"https://www.notion.so/Aide-en-ligne-SityTrail-FR-f5517d7ec74246ba87ed0c012b34bf2f\",\n" +
                "    \"public_url\": \"https://geolives.notion.site/Aide-en-ligne-SityTrail-FR-f5517d7ec74246ba87ed0c012b34bf2f\",\n" +
                "    \"request_id\": \"9473b65d-10ad-4da7-bf66-5f60614ff55e\"\n" +
                "}\n";
    }

    public static String getPageMentionRichText() {
        return "{\n" +
                "  \"type\": \"mention\",\n" +
                "  \"mention\": {\n" +
                "    \"type\": \"page\",\n" +
                "    \"page\": {\n" +
                "      \"id\": \"3c612f56-fdd0-4a30-a4d6-bda7d7426309\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"annotations\": {\n" +
                "    \"bold\": false,\n" +
                "    \"italic\": false,\n" +
                "    \"strikethrough\": false,\n" +
                "    \"underline\": false,\n" +
                "    \"code\": false,\n" +
                "    \"color\": \"default\"\n" +
                "  },\n" +
                "  \"plain_text\": \"This is a test page\",\n" +
                "  \"href\": \"https://www.notion.so/3c612f56fdd04a30a4d6bda7d7426309\"\n" +
                "}";
    }
}
