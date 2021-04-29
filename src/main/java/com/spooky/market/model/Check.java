package com.spooky.market.model;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.*;
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
    @XmlElement
    private Map<Item,Integer>items = new LinkedHashMap<>();
    @XmlElement
    @NotNull
    private Date date;
}
