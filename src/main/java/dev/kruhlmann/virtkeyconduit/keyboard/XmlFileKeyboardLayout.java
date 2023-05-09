package dev.kruhlmann.virtkeyconduit.keyboard;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dev.kruhlmann.virtkeyconduit.exception.UnknownKeyCodeException;

import java.util.HashMap;
import java.util.Map;

public class XmlFileKeyboardLayout implements KeyboardLayout {
    private String identifier;
    private Map<Integer, String> keys;

    public XmlFileKeyboardLayout(Document document) {
        this.identifier = document.getElementsByTagName("identifier").item(0).getTextContent();
        this.keys = new HashMap<>();

        NodeList nodeList = document.getElementsByTagName("key");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            int code = Integer.parseInt(node.getAttributes().getNamedItem("code").getNodeValue());
            String value = node.getAttributes().getNamedItem("value").getNodeValue();
            this.keys.put(code, value);
        }
    }

    @Override
    public String transcribe(char target) {
        int keyCode = (int) target;
        String transcription = keys.get(keyCode);
        if (transcription != null) {
            return transcription;
        }
        throw new UnknownKeyCodeException(keyCode);
    }

    @Override
    public String getUniqueStringIdentifier() {
        return this.identifier;
    }
}
