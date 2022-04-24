package com.gmail.evanloafakahaitao.hwk.hwk22.task4.impl;

import com.gmail.evanloafakahaitao.hwk.hwk22.task4.XMLParserService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParserService implements XMLParserService {

    @Override
    public String parseItems(String xml) {
        StringBuilder stringBuilder = new StringBuilder("{");
        try {
            File xmlFile = new File(xml);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("DOM Doc root = " + document.getDocumentElement().getNodeName());
            NodeList items = document.getElementsByTagName("Item");
            for (int i = 0; i < items.getLength(); i++) {
                Node node = items.item(i);
                System.out.println("Current node = " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    float price = Float.parseFloat(
                            element.getElementsByTagName("USPrice").item(0).getTextContent()
                    );
                    stringBuilder.append(
                            element.getElementsByTagName("ProductName").item(0).getTextContent()
                    ).append(" - ").append(price);
                    int quantity = Integer.parseInt(element.getElementsByTagName("Quantity").item(0).getTextContent());
                    if (quantity > 1) {
                        stringBuilder.append(String.format(": TOTAL=%f", price * quantity));
                    }
                }

                if (i == items.getLength() - 1) {
                    stringBuilder.append("}");
                } else stringBuilder.append(", ");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
