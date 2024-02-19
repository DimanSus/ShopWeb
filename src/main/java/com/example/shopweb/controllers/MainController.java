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
@RequestMapping("/")
public class MainController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    FireBaseService fireBaseService;
    @GetMapping
    public String getMainPage(Model model){
        List<ItemModel> list = itemRepo.findAll();
        list = list.stream().limit(5).collect(Collectors.toList());
        list= TimeHelper.getTime(list);
        list.stream().forEach(i->i.setUrl(fireBaseService.getUrl(i.getUrl())));
        model.addAttribute("items", list);
        return "index";
    }
}
