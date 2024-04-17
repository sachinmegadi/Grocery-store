package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.ItemDto;
import com.example.grocerystore.entity.Item;

public class ItemMapper {
    public static ItemDto mapToItemDto(Item item){
        ItemDto itemDto = new ItemDto(
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.getQuantity()
        );
        return itemDto;
    }

    public static Item mapToItem(ItemDto itemDto){
        Item item = new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getPrice(),
                itemDto.getQuantity()
        );
        return item;
    }
}
