package com.gmail.evanloafakahaitao.hwk.hwk22.task4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(propOrder = {"name", "quantity", "USPrice", "comment", "shipDate"})
public class Item {

    private String id;
    private String name;
    private int quantity;
    private float USPrice;
    private String comment;
    private Date shipDate;

    public String getId() {
        return id;
    }

    @XmlAttribute(name = "PartNumber")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "ProductName")
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    @XmlElement(name = "Quantity")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUSPrice() {
        return USPrice;
    }

    @XmlElement
    public void setUSPrice(float USPrice) {
        this.USPrice = USPrice;
    }

    public String getComment() {
        return comment;
    }

    @XmlElement(name = "Comment", nillable = true, required = false)
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getShipDate() {
        return shipDate;
    }

    @XmlElement(name = "ShipDate", nillable = true, required = false)
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", USPrice=").append(USPrice);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", shipDate=").append(shipDate);
        sb.append('}');
        return sb.toString();
    }
}
