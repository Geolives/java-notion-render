package com.geolives.helpers;

import com.geolives.entities.blocks.richtexts.Annotation;
import com.geolives.entities.blocks.richtexts.MentionRichText;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.blocks.richtexts.TextRichText;
import com.geolives.entities.blocks.richtexts.mentions.Mention;
import com.geolives.entities.blocks.richtexts.mentions.PageMention;
import com.geolives.entities.enums.Color;
import com.geolives.entities.enums.MentionRichTextType;
import com.geolives.entities.enums.RichTextType;
import com.geolives.exceptions.NotionIllegalArgumentException;
import com.geolives.utils.NotionUtils;

public class RichTextHelper {

    /** Builds a RichText array based on a single plain text content. */
    public static RichText fromText(String string) {
        return fromText(string, false, false, false);
    }

    /** Builds a RichText array based on a single plain text content. Additional flags can be enabled. */
    public static RichText fromText(String string, boolean bold, boolean italic, boolean underline) {
        return fromText(string, bold, italic, underline, Color.DEFAULT);
    }

    public static RichText fromText(String string, boolean bold, boolean italic, boolean underline, Color color) {
        TextRichText rt = new TextRichText();
        Annotation annotation = new Annotation();
        annotation.setColor(color);
        annotation.setBold(bold);
        annotation.setItalic(italic);
        annotation.setUnderline(underline);
        rt.setAnnotations(annotation);

        TextRichText.Text text = new TextRichText.Text();
        text.setContent(string);
        rt.setText(text);
        return rt;
    }

    /** Builds a RichText based on a link and content for the link. */
    public static RichText fromLink(String string, String link) {
        TextRichText rt = new TextRichText();
        Annotation annotation = new Annotation();
        rt.setAnnotations(annotation);

        TextRichText.Text text = new TextRichText.Text();
        text.setContent(string);
        text.setLinkUrl(link);
        rt.setText(text);
        return rt;
    }

    /** Builds a RichText based on a mention to a page. */
    public static RichText fromMention(String target, MentionRichTextType mentionType) throws NotionIllegalArgumentException {
        MentionRichText rt = new MentionRichText();
        if (mentionType == MentionRichTextType.PAGE) {
            PageMention pageMention = new PageMention();
            pageMention.setId(NotionUtils.dashifyId(target));
            rt.setMention(pageMention);
        }
        else {
            throw new RuntimeException("Mention type not supported");
        }

        return rt;
    }

    public static RichText spacer() {
        return fromText(" ");
    }
}
