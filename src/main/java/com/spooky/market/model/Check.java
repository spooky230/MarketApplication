package com.spooky.market.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Check {
    private Map<Item,Integer>items;
    private Date date;
    public Check(){
        items = new LinkedHashMap<>();
    }
    public Check(Date date){
        this.date = date;
        items = new LinkedHashMap<>();
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Map<Item, Integer> getItems() {
        return items;
    }
}
