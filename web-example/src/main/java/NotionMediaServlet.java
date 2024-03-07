import be.doubotis.notion.render.theme.notion.renders.BlockImageRender;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geolives.entities.blocks.Block;
import com.geolives.entities.blocks.ImageBlock;
import com.geolives.entities.pages.Page;
import com.geolives.utils.NotionUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet(name = "NotionMediaServlet", urlPatterns = {"/NotionMediaServlet/*"})
public class NotionMediaServlet extends HttpServlet {
    final OkHttpClient client = new OkHttpClient();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        String[] components = requestURI.split("/");
        String pageId = components[2];
        String blockId = components[3];

        String resourceName = "/page-" + pageId.replace("-", "") + ".json";
        InputStream is = getClass().getResourceAsStream(resourceName);
        if (is == null) {
            // Send a 404 error if resource is not found.
            resp.sendError(404);
            return;
        }

        // Build an InputStreamReader to pass it to an ObjectMapper.
        final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        final ObjectMapper om = NotionUtils.getNotionMapper();
        final Page page = om.readValue(isr, Page.class);
        Map<String, Block> blockMap = page.getChildrenMap();

        final Block block = blockMap.get(blockId);
        if(!(block instanceof ImageBlock imageBlock)) {
            resp.sendError(404);
            return;
        }
        final String imageUrl = imageBlock.getImageUrl();

        final BlockImageRender bir = new BlockImageRender();
        final String src = bir.buildNonSecuredNotionStorageUrl(imageBlock.getImageUrl(), blockId);
        Request request = new Request.Builder()
                .url(src)
                .build();

        try (Response response = this.client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                resp.sendError(404);
                return;
            }
            final String extension = imageUrl.substring(imageUrl.lastIndexOf('.')+1, imageUrl.lastIndexOf('?'));
            if(response.body() != null) {
                InputStream inputStream = response.body().byteStream();
                resp.setContentType(getContentTypeFromExtension(extension));
                IOUtils.copy(inputStream, resp.getOutputStream());
            } else {
                resp.sendError(404);
            }
        } catch (IOException e) {
            e.printStackTrace();
            resp.sendError(404);
        }
    }

    private String getContentTypeFromExtension(String extension) {
        if (extension.equals("jpg") || extension.equals("jpeg")) {
            return "image/jpeg";
        }
        else if (extension.equals("png")) {
            return "image/png";
        }
        return "";
    }
}
