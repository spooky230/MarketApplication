package com.spooky.market.service.adapter;

import com.spooky.market.model.Item;
import com.spooky.market.model.dto.ItemCollectionDto;
import com.spooky.market.model.dto.ItemDto;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ItemMapAdapter extends XmlAdapter<ItemCollectionDto, Map<Item,Integer>>{


    @Override
    public ItemCollectionDto marshal(Map<Item, Integer> itemsMap) throws Exception {

        ItemCollectionDto itemDtos = new ItemCollectionDto();
        itemsMap.forEach((item, count) -> itemDtos.getItems().add(new ItemDto(item.getName(),item.getPrice(),count)));
        return itemDtos;
    }

    @Override
    public Map<Item, Integer> unmarshal(ItemCollectionDto dtoList) throws Exception {

        Map<Item, Integer> itemsMap = new HashMap<>();
        dtoList.getItems().forEach(itemDto -> itemsMap.put(itemDto,itemDto.getQuantity()));
        return itemsMap;
    }
}
