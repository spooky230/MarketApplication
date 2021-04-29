package com.spooky.market.model.dto;

import com.spooky.market.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(propOrder = {"name","price","count"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDto extends Item {
    @XmlAttribute
    private int count;
}
