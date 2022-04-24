package com.gmail.evanloafakahaitao.hwk.hwk22;

import com.gmail.evanloafakahaitao.hwk.hwk22.task1.MyThreadFactory;
import com.gmail.evanloafakahaitao.hwk.hwk22.task2.Player;
import com.gmail.evanloafakahaitao.hwk.hwk22.task2.PlayerTaskService;
import com.gmail.evanloafakahaitao.hwk.hwk22.task3.XMLValidatorService;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.XMLParserFactory;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.XMLParserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //T1
        String phrase = "Iny any programming language arrays are used that are convenient for " +
                "working with a large number of the same type of date";
        String filePattern = "my\\myfile%d.txt";
        MyThreadFactory myThreadFactory = MyThreadFactory.getInstance();
        myThreadFactory.createWriterThreads(filePattern, phrase);

        //T2
        PlayerTaskService playerTaskService = PlayerTaskService.getInstance();
        List<String> files = playerTaskService.generatePlayers();
        List<Player> players = playerTaskService.readAndSortPlayers(files);
        System.out.println(players);

        //T3
        String xml = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk22\\task3\\order.xml";
        String xsd = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk22\\task3\\order.xsd";
        XMLValidatorService validator = new XMLValidatorService();
        boolean isValid = validator.validateXmlAgainstXsd(xml, xsd);
        System.out.println("XML validity = " + isValid);

        //T4
        String xmlItems = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk22\\task3\\order.xml";
        XMLParserFactory xmlParserFactory = XMLParserFactory.getInstance();
        XMLParserService domParser = xmlParserFactory.getParser(XMLParserFactory.ParserType.DOM);
        String resultDOM = domParser.parseItems(xmlItems);
        System.out.printf("DOM Result : %s%n", resultDOM);
        XMLParserService saxParser = xmlParserFactory.getParser(XMLParserFactory.ParserType.SAX);
        String resultSAX = saxParser.parseItems(xmlItems);
        System.out.printf("SAX Result : %s%n", resultSAX);
        XMLParserService jaxbParser = xmlParserFactory.getParser(XMLParserFactory.ParserType.JAXB);
        String resultJAXB = jaxbParser.parseItems(xmlItems);
        System.out.printf("JAXB Result : %s%n", resultJAXB);


    }
}
