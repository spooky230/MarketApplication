package com.spooky.market.model;

import com.spooky.market.service.adapter.ItemMapAdapter;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"cashier","market","row","date","items"})
public class Check {
    @XmlElement
    private Cashier cashier;
    @XmlElement
    private Market market;
    @XmlElement
    private int row;
    @XmlJavaTypeAdapter(ItemMapAdapter.class)
    @XmlElement
    private Map<Item,Integer>items = new LinkedHashMap<>();
    @XmlElement
    @NotNull
    private Date date;
}
