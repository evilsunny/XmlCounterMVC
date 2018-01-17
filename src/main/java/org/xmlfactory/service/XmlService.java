package org.xmlfactory.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

@Component
@Service
public class XmlService {

    private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    @Value("${file.location}")
    private String fileName;

    public List<String> getNodeValues(String nameNode, int count) {
        DocumentBuilder db = null;
        List<String> result = new LinkedList<>();

        try {
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(fileName));
            visit(doc, 0, nameNode, count, result);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    // Recursively visit each node
    private void visit(Node node, int level, String nodeName, int count, List<String> result) {
        if (result.size() >= count) return;
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            if (childNode.getNodeName().equals(nodeName) && (result.size() < count)) {
                result.add(childNode.getTextContent());
            }
            visit(childNode, level + 1, nodeName, count, result);
        }
    }

    public String readFromFile() {
        String xml2String = "";
        File xmlFile = new File(fileName);
        Reader fileReader = null;
        try {
            fileReader = new FileReader(xmlFile);
            BufferedReader bufReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }
            xml2String = sb.toString();
            System.out.println("XML to String using BufferedReader : ");
            System.out.println(xml2String);
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xmlEscapeText(xml2String);
    }

    private String xmlEscapeText(String t) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                default:
                    if (c > 0x7e) {
                        sb.append("&#").append((int) c).append(";");
                    } else
                        sb.append(c);
            }
        }
        return sb.toString();
    }

}


