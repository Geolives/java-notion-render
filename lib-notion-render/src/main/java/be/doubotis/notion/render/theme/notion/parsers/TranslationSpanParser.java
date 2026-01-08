package be.doubotis.notion.render.theme.notion.parsers;

import com.geolives.entities.blocks.richtexts.Annotation;
import com.geolives.entities.blocks.richtexts.MentionRichText;
import com.geolives.entities.blocks.richtexts.RichText;
import com.geolives.entities.blocks.richtexts.TextRichText;
import com.geolives.entities.blocks.richtexts.mentions.PageMention;
import com.geolives.entities.enums.Color;
import com.geolives.entities.enums.RichTextType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Parser that is suitable to use to convert back translation HTML blocks to RichText arrays. */
public class TranslationSpanParser {

    public RichText[] parse(String html) {
        Document doc = Jsoup.parse(html, "", Parser.xmlParser());

        List<RichText> result = new ArrayList<RichText>();
        List<Node> nodes = doc.childNodes();

        for (int i = 0; i < nodes.size(); i++) {
            parseNode(nodes.get(i), result);
        }

        return result.toArray(new RichText[0]);
    }

    private void parseNode(Node node, List<RichText> result) {
        if (node instanceof TextNode) {
            TextNode textNode = (TextNode) node;
            String text = textNode.text();
            if (text != null && !text.isEmpty()) {
                result.add(buildTextRichText(text, null));
            }
            return;
        }

        if (!(node instanceof Element)) {
            return;
        }

        Element element = (Element) node;
        String tag = element.tagName();

        if ("span".equals(tag)) {
            Annotation annotation = parseAnnotations(element);
            String text = element.text();
            if (text != null && !text.isEmpty()) {
                result.add(buildTextRichText(text, annotation));
            }
            return;
        }

        if ("page".equals(tag)) {
            String id = element.attr("id");
            result.add(buildPageMention(id));
            return;
        }

        // fallback: recurse into children to not lose text
        List<Node> children = element.childNodes();
        for (int i = 0; i < children.size(); i++) {
            parseNode(children.get(i), result);
        }
    }

    private TextRichText buildTextRichText(String text, Annotation annotation) {
        TextRichText rt = new TextRichText();

        TextRichText.Text txt = new TextRichText.Text();
        txt.setContent(text);

        rt.setText(txt);
        rt.setAnnotations(annotation != null ? annotation : defaultAnnotation());
        return rt;
    }

    private MentionRichText buildPageMention(String pageId) {
        PageMention pageMention = new PageMention();
        pageMention.setId(pageId);

        MentionRichText mention = new MentionRichText();
        mention.setType(RichTextType.MENTION);
        mention.setMention(pageMention);
        mention.setPlainText("");
        mention.setAnnotations(defaultAnnotation());

        return mention;
    }

    private Annotation parseAnnotations(Element span) {
        Annotation a = new Annotation();
        a.setColor(Color.DEFAULT);

        Set<String> classes = span.classNames();
        for (String className : classes) {

            if (className.startsWith("color-")) {
                String colorValue = className.substring("color-".length());
                // suppose que Color.fromValue(String) existe chez toi (sinon voir note plus bas)
                a.setColor(Color.fromValue(colorValue));
                continue;
            }

            if ("style-bold".equals(className)) {
                a.setBold(true);
            } else if ("style-italic".equals(className)) {
                a.setItalic(true);
            } else if ("style-underline".equals(className)) {
                a.setUnderline(true);
            } else if ("style-strikethrough".equals(className)) {
                a.setStrikethrough(true);
            } else if ("style-underline-strikethrough".equals(className)) {
                a.setUnderline(true);
                a.setStrikethrough(true);
            }
        }

        return a;
    }

    private Annotation defaultAnnotation() {
        Annotation annotation = new Annotation();
        annotation.setColor(Color.DEFAULT);
        return annotation;
    }
}