package com.example.grocerystore.serviceImpl;

import com.example.grocerystore.dto.ItemDto;
import com.example.grocerystore.entity.Item;
import com.example.grocerystore.mapper.ItemMapper;
import com.example.grocerystore.repository.ItemRepository;
import com.example.grocerystore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item item = ItemMapper.mapToItem(itemDto);
        Item savedItem = itemRepository.save(item);
        return ItemMapper.mapToItemDto(savedItem);
    }

    @Override
    public ItemDto getItemById(Long id) {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Item is out of stock"));
        return ItemMapper.mapToItemDto(item);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item is not present"));
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDto sellItemById(Long id, int quantity) {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Item is not available"));
        if(item.getQuantity() >= quantity){
            int availableQuantity = item.getQuantity() - quantity;
            item.setQuantity(availableQuantity);
        }else {
            throw new RuntimeException("Item is out of stock");
        }
        Item savedItem = itemRepository.save(item);
        return ItemMapper.mapToItemDto(savedItem);
    }

    @Override
    public ItemDto restockItem(Long id, int quantity) {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Item is not available"));
        item.setQuantity(item.getQuantity() + quantity);
        Item savedItem = itemRepository.save(item);
        return ItemMapper.mapToItemDto(savedItem);
    }
}
