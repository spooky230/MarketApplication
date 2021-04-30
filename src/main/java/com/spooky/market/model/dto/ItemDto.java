package com.spooky.market.model.dto;

import com.spooky.market.model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@XmlType
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDto extends Item {
    @XmlAttribute
    private int quantity;

    @Builder
    public ItemDto(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }
}
