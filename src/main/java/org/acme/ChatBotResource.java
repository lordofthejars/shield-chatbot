package org.acme;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.langchain4j.model.chat.ChatLanguageModel;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class ChatBotResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(Text...texts);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return Templates.index(new Text("Correct", "Tell a story about a frog"));
    }

    @Inject
    ObjectMapper mapper;

    @Inject
    private ChatLanguageModel chatModel;

    @GET
    @Path("blocking")
    public String blocking() {
        return chatModel.generate("When was the nobel prize for economics first awarded?");
    }

    @POST
    @Path("/chat")
    public JsonNode chat(JsonNode node) {
        System.out.println(node.get("message").asText());
        final ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("reply", "aaaaa");

        return objectNode;
    }

}
