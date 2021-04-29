package com.spooky.market.service.adapter;

import com.spooky.market.model.Item;
import com.spooky.market.model.dto.ItemDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.List;
import java.util.Map;

public class ItemMapAddapter extends XmlAdapter<List<ItemDto>, Map<Item,Integer>>{


    @Override
    public Map<Item, Integer> unmarshal(List<ItemDto> v) throws Exception {
        return null;
    }

    @Override
    public List<ItemDto> marshal(Map<Item, Integer> v) throws Exception {
        return null;
    }
}
