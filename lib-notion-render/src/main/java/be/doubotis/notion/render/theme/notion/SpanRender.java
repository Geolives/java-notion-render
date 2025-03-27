package be.doubotis.notion.render.theme.notion;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.TextRender;
import com.geolives.entities.blocks.richtexts.Annotation;
import com.geolives.entities.blocks.richtexts.MentionRichText;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.blocks.richtexts.TextRichText;
import com.geolives.entities.blocks.richtexts.mentions.Mention;
import com.geolives.entities.blocks.richtexts.mentions.PageMention;
import com.geolives.entities.enums.MentionRichTextType;
import com.geolives.entities.enums.RichTextType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.*;

public class SpanRender implements TextRender {

    protected RenderContext context;
    protected Document domBuilder;

    public SpanRender(RenderContext context) {
        this.context = context;
        this.domBuilder = Jsoup.parse("");
    }

    @Override
    public String renderText(RichText[] richTexts) {
        StringBuilder sb = new StringBuilder();
        for(RichText richText : richTexts) {
            Element span = this.domBuilder.createElement("span");
            if(richText.getType() == RichTextType.TEXT) {
                renderTextRichText(span, (TextRichText) richText);
            } else if (richText.getType() == RichTextType.MENTION) {
                renderMentionRichText(span, (MentionRichText) richText);
            }
            addCSSClasses(span, richText.getAnnotations());
            sb.append(span.outerHtml());
        }

        return sb.toString();

    }

    protected void renderMentionRichText(final Element span, final MentionRichText richText) {
        final Mention mention = richText.getMention();
        if(mention.getType() == MentionRichTextType.PAGE) {
            renderPageMentionRichText(span, richText, (PageMention) mention);
        }
    }

    protected void renderPageMentionRichText(final Element span, final MentionRichText richText, final PageMention mention) {
        final Element a = domBuilder.createElement("a");
        a.addClass("page-link");
        a.attr("href", this.context.buildLinkUrl(mention.getId()));
        a.text(richText.getPlainText());
        span.appendChild(a);
    }

    protected void renderTextRichText(final Element span, final TextRichText richText) {
        if(richText.getLinkUrl() != null) {
            final Element a = domBuilder.createElement("a");
            a.attr("href", richText.getLinkUrl());
            a.html(richText.getContent().replace("\n", "<br/>"));
            span.appendChild(a);
        } else {
            span.html(richText.getContent().replace("\n", "<br/>"));
        }
    }

    protected void addCSSClasses(final Element span, final Annotation annotations) {
        span.addClass("color-"+ annotations.getColor().getValue());
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

//    private ArrayList extractFromJsonArray(List array) {
//        ArrayList data = new ArrayList();
//        if (array != null) {
//            for (int i=0;i<array.size();i++){
//                data.add(array.get(i));
//            }
//        }
//        return data;
//    }
//
//    private String buildSpanHTML(boolean closure, List tags) {
//
//        Primitive tagPrimitive = Primitive.from(tags.get(0));
//        String tag = tagPrimitive.getContent();
//        if (tag.equals("p")) {
//            // Specific case.
//            if (!closure) {
//                Primitive idPrimitive = Primitive.from(tags.get(1));
//                String id = idPrimitive.getContent();
//                String url = mContext.buildLinkUrl(id);
//                return "<a class=\"page-link\" href=\"" + url + "\" data-binding=\"" + id + "\"><i class=\"fas fa-link\"></i>";
//            } else {
//                return "</a>";
//            }
//        }
//        else if (tag.equals("a")) {
//            // Specific case.
//            if (!closure) {
//                Primitive urlPrimitive = Primitive.from(tags.get(1));
//                String url = urlPrimitive.getContent();
//                return "<a class=\"web-link\" href=\"" + url + "\">";
//            } else {
//                return "</a>";
//            }
//        }
//        else
//        {
//            List<String> handlesCases = Arrays.asList(new String[] { "_", "b", "s", "i", "h" });
//            // Span case.
//            if (!closure) {
//                if (tag.equals("_")) {
//                    return "<span style=\"text-decoration: underline;\">";
//                } else if (tag.equals("b")) {
//                    return "<span style=\"font-weight: bold;\">";
//                } else if (tag.equals("s")) {
//                    return "<span style=\"text-decoration: line-through;\">";
//                } else if (tag.equals("i")) {
//                    return "<span style=\"font-style: italic;\">";
//                } else if (tag.equals("h")) {
//                    Primitive colorPrimitive = Primitive.from(tags.get(1));
//                    String color = colorPrimitive.getContent();
//                    return "<span style=\"color: " + color + ";\">";
//                } else {
//                    return "";
//                }
//            } else {
//                if (handlesCases.contains(tag)) {
//                    return "</span>";
//                } else {
//                    return "";
//                }
//            }
//        }
//    }
}
