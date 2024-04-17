package com.example.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
