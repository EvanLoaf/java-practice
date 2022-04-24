package com.gmail.evanloafakahaitao.hwk.hwk22.task4.impl;

import com.gmail.evanloafakahaitao.hwk.hwk22.task4.Item;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.Items;
import com.gmail.evanloafakahaitao.hwk.hwk22.task4.XMLParserService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBParserService implements XMLParserService {

    private String unmarshal(String xml) {
        StringBuilder stringBuilder = new StringBuilder("{");
        try {
            File xmlFile = new File(xml);
            JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Items items = (Items) unmarshaller.unmarshal(xmlFile);
            System.out.println(items);
            List<Item> itemList = items.getItemList();
            for (Item item : itemList) {
                System.out.println(item);
                stringBuilder.append(item.getName()).append(" - ");
                float price = item.getUSPrice();
                stringBuilder.append(price);
                int quant = item.getQuantity();
                if (quant > 1) {
                    stringBuilder.append(
                            String.format(": TOTAL=%f", price * quant)
                    );
                }
                stringBuilder.append(", ");
            }
            if (stringBuilder.length() > 1) {
                stringBuilder.replace(stringBuilder.length() -2, stringBuilder.length(), "}");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public String parseItems(String xml) {
        return unmarshal(xml);
    }
}
