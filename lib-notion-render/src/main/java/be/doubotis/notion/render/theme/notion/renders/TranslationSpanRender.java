package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import com.geolives.entities.blocks.richtexts.Annotation;
import com.geolives.entities.blocks.richtexts.MentionRichText;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.blocks.richtexts.TextRichText;
import com.geolives.entities.blocks.richtexts.mentions.PageMention;
import com.geolives.entities.enums.Color;
import com.geolives.entities.enums.RichTextType;
import org.jsoup.nodes.Element;

/** Span render that could be used for translation purposes. This converts the RichText array to
 * a simple HTML block suitable for translation purposes. */
public class TranslationSpanRender extends SpanRender {

    public TranslationSpanRender(RenderContext context) {
        super(context);
    }

    @Override
    public String renderText(RichText[] richTexts) {
        StringBuilder sb = new StringBuilder();
        for(RichText richText : richTexts) {
            if(richText.getType() == RichTextType.TEXT) {
                Element span = this.domBuilder.createElement("span");
                addCSSClasses(span, richText.getAnnotations());
                renderTextRichText(span, (TextRichText) richText);

                String html = span.outerHtml();

                // Specific case, if <span> is empty with no additional info, we can remove the span itself.
                if (html.contains("<span>")) {
                    html = span.outerHtml().replace("<span>", "")
                            .replace("</span>", "");
                }
                sb.append(html);
            } else if (richText.getType() == RichTextType.MENTION) {
                renderPageMentionRichText(sb, (MentionRichText) richText, (PageMention) ((MentionRichText) richText).getMention());
            }
        }

        return sb.toString();
    }

    protected void renderPageMentionRichText(final StringBuilder sb, final MentionRichText richText, final PageMention mention) {
        // Jsoup cannot help us here, just build the page tag manually.
        String html = "<page id=\"" + mention.getId() + "\" />";
        sb.append(html);
    }

    @Override
    protected void addCSSClasses(final Element span, final Annotation annotations) {
        if (annotations.getColor() != null && annotations.getColor() != Color.DEFAULT) {
            span.addClass("color-"+ annotations.getColor().getValue());
        }

        if(annotations.isBold()) {
            span.addClass("style-bold");
        }
        if(annotations.isItalic()) {
            span.addClass("style-italic");
        }
        if(annotations.isStrikethrough() && !annotations.isUnderline()) {
            span.addClass("style-strikethrough");
        }
        if(annotations.isUnderline() && !annotations.isStrikethrough()) {
            span.addClass("style-underline");
        }
        if(annotations.isUnderline() && annotations.isStrikethrough()) {
            span.addClass("style-underline-strikethrough");
        }

    }
}

