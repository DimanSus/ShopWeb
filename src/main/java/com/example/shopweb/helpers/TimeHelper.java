package com.example.shopweb.helpers;

import com.example.shopweb.models.ItemModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeHelper {
    public static List<ItemModel> getTime(List<ItemModel> list){
        for(ItemModel i : list){
            SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("HH:mm dd.MM");
            i.setTimeFormat(simpleDateFormat.format(new Date(i.getTime())));
        }
        return list;
    }
}
