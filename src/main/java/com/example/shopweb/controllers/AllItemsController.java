package com.example.shopweb.controllers;

import com.example.shopweb.helpers.TimeHelper;
import com.example.shopweb.models.ItemModel;
import com.example.shopweb.repos.ItemRepo;
import com.example.shopweb.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/allItems")
public class AllItemsController {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    private FireBaseService fireBaseService;

    @GetMapping
    public String getAllItemController(Model model){
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("items", list);
        list.stream().forEach(i->i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list= TimeHelper.getTime(list);
        return "allItem";
    }
}
