package be.doubotis.notion.render.theme.notion.renders;

import be.doubotis.notion.render.RenderContext;
import be.doubotis.notion.render.BlockRender;
import be.doubotis.notion.render.engine.DOMBuilder;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.parents.*;
import org.jsoup.nodes.Element;

public abstract class BlockBaseRender implements BlockRender {

    protected void insertIntoDocument(DOMBuilder dom, RenderContext context, String parentId, Element element) {
        insertIntoDocument(dom, context, parentId, element, null);
    }

    protected void insertIntoDocument(DOMBuilder dom, RenderContext context, String parentId, Element element, String listType) {
        if(listType == null) {
            insertElementIntoDocument(dom, context, parentId, element);
        } else {
            insertLiElementIntoDocument(dom, context, parentId, element, listType);
        }
    }

    private void insertLiElementIntoDocument(DOMBuilder dom, RenderContext context, String parentId, Element element, String listType) {
        final Element parent;
        if(parentId.equals(context.getPageID())) {
            parent = dom.getDocument();
        } else {
            parent = dom.querySelector("#" + parentId);
        }
        final Element lastChild = parent.child(parent.childrenSize()-1);
        if(lastChild.tagName().equals(listType)) {
            lastChild.appendChild(element);
        } else {
            final Element list = dom.createElement(listType, null);
            parent.appendChild(list);
            list.appendChild(element);

        }
    }

    private void insertElementIntoDocument(DOMBuilder dom, RenderContext context, String parentId, Element element) {
        if (parentId == null || parentId.equals(context.getPageID())) {
            dom.getDocument().appendChild(element);
        } else {
            Element parent = dom.querySelector("#" + parentId);
            if (parent != null) {
                parent.appendChild(element);
            }
        }
    }

    protected String getParentId(final Parent parent) {
        return switch (parent.getType()) {
            case PAGE -> ((PageParent) parent).getPageId();
            case BLOCK -> ((BlockParent) parent).getBlockId();
            case DATABASEID -> ((DatabaseParent) parent).getDatabaseId();
            default -> "";
        };

    }
}
