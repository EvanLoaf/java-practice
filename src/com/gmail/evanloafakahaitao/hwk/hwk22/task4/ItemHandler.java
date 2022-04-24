package com.gmail.evanloafakahaitao.hwk.hwk22.task4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ItemHandler extends DefaultHandler {

    private StringBuilder result;
    private boolean isName = false;
    private boolean isPrice = false;
    private boolean isQuantity = false;
    private int lastQuantity;

    public ItemHandler() {
        this.result = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        result.append("{");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.printf("Starting element %s%n", qName);
        if (qName.equalsIgnoreCase("ProductName")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("USPrice")) {
            isPrice = true;
        } else if (qName.equalsIgnoreCase("Quantity")) {
            isQuantity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.printf("Exiting element %s%n", qName);
        if (qName.equalsIgnoreCase("Item")) result.append(", ");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            result.append(
                    new String(ch, start, length)
            ).append(" - ");
            isName = false;
        } else if (isPrice) {
            float price = Float.valueOf(new String(ch, start, length));
            result.append(price);
            if (lastQuantity > 1) {
                result.append(String.format(": TOTAL=%f", lastQuantity * price));
            }
            isPrice = false;
        } else if (isQuantity) {
            lastQuantity = Integer.parseInt(new String(ch, start, length));
            isQuantity = false;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        if (result.length() > 1) {
            result.replace(result.length() -2, result.length(), "}");
        }
    }

    public String getResult() {
        return result.toString();
    }
}
