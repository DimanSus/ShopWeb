package com.example.shopweb.repos;

import com.example.shopweb.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItemRepo extends JpaRepository<ItemModel, Long> {
    ItemModel findById(long id);
    List<ItemModel> findAllByType(String type);
}
