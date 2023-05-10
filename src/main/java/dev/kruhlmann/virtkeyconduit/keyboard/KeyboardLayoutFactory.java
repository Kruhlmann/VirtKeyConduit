package dev.kruhlmann.virtkeyconduit.keyboard;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import dev.kruhlmann.virtkeyconduit.exception.UnknownKeyboardLayoutException;

public class KeyboardLayoutFactory {
    public KeyboardLayout from_string_identifier(String identifier) throws ParserConfigurationException, SAXException, IOException, UnknownKeyboardLayoutException {
        String xmlFilename = identifier + ".xml";
        File xmlFile = new File(xmlFilename);
        if (xmlFile.exists()) {
          return this.xmlFileToLayout(xmlFile);
        }

        xmlFilename = "/usr/share/vkc/keyboards/" + identifier + ".xml";
        xmlFile = new File(xmlFilename);
        if (xmlFile.exists()) {
          return this.xmlFileToLayout(xmlFile);
        }

        throw new UnknownKeyboardLayoutException(identifier);
    }

    private XmlFileKeyboardLayout xmlFileToLayout(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document document = documentBuilder.parse(xmlFile);
      return new XmlFileKeyboardLayout(document);
  }
}
