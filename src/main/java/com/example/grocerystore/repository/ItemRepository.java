package com.example.grocerystore.repository;

import com.example.grocerystore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
