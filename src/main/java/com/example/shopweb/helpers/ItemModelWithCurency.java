package com.example.shopweb.helpers;

import com.example.shopweb.models.ItemModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ItemModelWithCurency {

    private Long id;


    private String name;


    double price;


    private String disc;


    private String url;


    Long time;


    private String type;

    private String timeFormat;

    private double usdPrice;

    private double eurPrice;

    public ItemModelWithCurency() {
    }

    public ItemModelWithCurency(ItemModel itemModel) {
        this.id = itemModel.getId();
        this.name = itemModel.getName();
        this.price = itemModel.getPrice();
        this.disc = itemModel.getDisc();
        this.url = itemModel.getUrl();
        this.time = itemModel.getTime();
        this.type = itemModel.getType();
        this.timeFormat = itemModel.getTimeFormat();
    }
}
