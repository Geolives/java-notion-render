package com.geolives.entities.blocks.richtexts;

import com.geolives.entities.blocks.richtexts.mentions.Mention;
import com.geolives.entities.enums.RichTextType;
public class MentionRichText extends RichText {
    private Mention mention;
    public MentionRichText() {
        super(RichTextType.MENTION);
    }

    public Mention getMention() {
        return this.mention;
    }

    public void setMention(final Mention mention) {
        this.mention = mention;
    }
}
