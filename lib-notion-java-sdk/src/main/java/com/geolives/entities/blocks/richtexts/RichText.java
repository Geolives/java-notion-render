package com.geolives.entities.blocks.richtexts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geolives.entities.enums.RichTextType;
import com.geolives.entities.enums.constants.ParentTypeConstants;
import com.geolives.entities.enums.constants.RichTextTypeConstants;
import com.geolives.entities.parents.BlockParent;
import com.geolives.entities.parents.DatabaseParent;
import com.geolives.entities.parents.PageParent;
import com.geolives.entities.parents.WorkspaceParent;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextRichText.class, name = RichTextTypeConstants.TEXT),
        @JsonSubTypes.Type(value = MentionRichText.class, name = RichTextTypeConstants.MENTION)
})
public class RichText {

    private Annotation annotations;
    @JsonIgnore()
    private RichTextType type;
    private String plainText;
    private String href;

    public RichText() {}

    public RichText(final RichTextType type) {
        this.type = type;
    }

    public Annotation getAnnotations() {
        return this.annotations;
    }

    public void setAnnotations(final Annotation annotations) {
        this.annotations = annotations;
    }

    public RichTextType getType() {
        return this.type;
    }

    public void setType(final RichTextType type) {
        this.type = type;
    }

    public String getPlainText() {
        return this.plainText;
    }

    public void setPlainText(final String plainText) {
        this.plainText = plainText;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(final String href) {
        this.href = href;
    }
}
