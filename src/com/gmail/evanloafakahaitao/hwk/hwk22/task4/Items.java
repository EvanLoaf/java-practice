package com.gmail.evanloafakahaitao.hwk.hwk22.task4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "PurchaseOrder")
public class Items {

    private List<Item> itemList;
    private Date orderDate;

    public List<Item> getItemList() {
        return itemList;
    }

    @XmlElement(name = "Item")
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @XmlAttribute(name = "OrderDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Items{");
        sb.append("itemList=").append(itemList);
        sb.append('}');
        return sb.toString();
    }
}
