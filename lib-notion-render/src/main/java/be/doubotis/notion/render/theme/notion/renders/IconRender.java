package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.icons.EmojiIcon;
import com.geolives.entities.icons.ExternalFileIcon;
import com.geolives.entities.icons.Icon;
import com.geolives.entities.icons.InternalFileIcon;
import org.jsoup.nodes.Element;

public class IconRender {

    public Element render(final DOMBuilder domBuilder, final Icon icon) {
        Element iconElement = null;
        if(icon instanceof EmojiIcon emojiIcon) {
            iconElement = renderEmojiIcon(domBuilder, emojiIcon);
        } else if(icon instanceof InternalFileIcon internalFileIcon) {
            iconElement = renderInternalFileIcon(domBuilder, internalFileIcon);
        } else if(icon instanceof ExternalFileIcon externalFileIcon) {
            iconElement = renderExternalFileIcon(domBuilder, externalFileIcon);
        }
        return iconElement;
    }

    private Element renderExternalFileIcon(final DOMBuilder domBuilder, final ExternalFileIcon externalFileIcon) {
        final Element img = domBuilder.createElement("img", null);
        img.attr("src", externalFileIcon.getExternal().getUrl());
        return img;
    }

    private Element renderInternalFileIcon(final DOMBuilder domBuilder, final InternalFileIcon internalFileIcon) {
        final Element img = domBuilder.createElement("img", null);
        img.attr("src", internalFileIcon.getFile().getUrl());
        return img;
    }

    private Element renderEmojiIcon(final DOMBuilder domBuilder, final EmojiIcon emojiIcon) {
        final Element span = domBuilder.createElement("span", null);
        span.text(emojiIcon.getEmoji());
        return span;
    }
}
