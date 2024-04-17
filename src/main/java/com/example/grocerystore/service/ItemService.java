package com.example.grocerystore.service;

import com.example.grocerystore.dto.ItemDto;

public interface ItemService {
    ItemDto addItem(ItemDto itemDto);
    ItemDto getItemById(Long id);
    void deleteItemById(Long id);
    ItemDto sellItemById(Long id, int quantity);
    ItemDto restockItem(Long id, int quantity);
}
