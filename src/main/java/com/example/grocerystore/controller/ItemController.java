package com.example.grocerystore.controller;

import com.example.grocerystore.dto.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.grocerystore.service.ItemService;

import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.addItem(itemDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        ItemDto itemDto = itemService.getItemById(id);
        return ResponseEntity.ok(itemDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        itemService.deleteItemById(id);
        return ResponseEntity.ok("Item removed successfully");
    }

    @PutMapping("/{id}/sell")
    public ResponseEntity<ItemDto> sellItemById(@PathVariable Long id,
                                                @RequestBody Map<String, Integer> request){
        int quantity = request.get("quantity");
        ItemDto itemDto = itemService.sellItemById(id,quantity);
        return ResponseEntity.ok(itemDto);
    }

    @PutMapping("/{id}/restock")
    public ResponseEntity<ItemDto> restockItemById(@PathVariable Long id,
                                                @RequestBody Map<String, Integer> request){
        int quantity = request.get("quantity");
        ItemDto itemDto = itemService.restockItem(id,quantity);
        return ResponseEntity.ok(itemDto);
    }
}
