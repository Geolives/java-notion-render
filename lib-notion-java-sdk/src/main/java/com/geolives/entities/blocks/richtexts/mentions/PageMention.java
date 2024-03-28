package com.geolives.entities.blocks.richtexts.mentions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geolives.entities.enums.MentionRichTextType;

public class PageMention extends Mention {
    private PageMentionObject page;

    public PageMention() {super(MentionRichTextType.PAGE);}

    public PageMentionObject getPage() {
        return this.page;
    }

    public void setPage(final PageMentionObject page) {
        this.page = page;
    }

    @JsonIgnore
    public String getId() {
        return this.page.getId();
    }

    @JsonIgnore
    public void setId(final String id) {
        this.page.setId(id);
    }

    private class PageMentionObject {
        private String id;

        public PageMentionObject() {}

        public String getId() {
            return this.id;
        }

        public void setId(final String id) {
            this.id = id;
        }
    }
}
