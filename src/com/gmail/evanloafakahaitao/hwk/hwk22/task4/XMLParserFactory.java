package com.gmail.evanloafakahaitao.hwk.hwk22.task4;

import com.gmail.evanloafakahaitao.hwk.hwk22.task4.impl.DOMParserService;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.impl.JAXBParserService;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.impl.SAXParserService;

public class XMLParserFactory {

    private XMLParserFactory() {}

    private static class Holder {
        private static XMLParserFactory xmlParserFactory = new XMLParserFactory();
    }

    public static XMLParserFactory getInstance() {
        return Holder.xmlParserFactory;
    }

    public XMLParserService getParser(ParserType type) {
        switch (type) {
            case DOM: return new DOMParserService();
            case SAX: return new SAXParserService();
            case JAXB: return new JAXBParserService();
                default: return new DOMParserService();
        }
    }

    public enum ParserType {
        DOM,
        SAX,
        JAXB
    }
}
