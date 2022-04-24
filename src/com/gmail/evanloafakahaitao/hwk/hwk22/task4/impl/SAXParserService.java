package com.gmail.evanloafakahaitao.hwk.hwk22.task4.impl;

import com.gmail.evanloafakahaitao.hwk.hwk22.task4.ItemHandler;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.XMLParserService;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParserService implements XMLParserService {

    @Override
    public String parseItems(String xml) {
        DefaultHandler itemHandler = new ItemHandler();
        try {
            File xmlFile = new File(xml);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(xmlFile, itemHandler);
            return ((ItemHandler) itemHandler).getResult();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ((ItemHandler) itemHandler).getResult();
    }
}
