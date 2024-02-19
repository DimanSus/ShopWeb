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

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    FireBaseService fireBaseService;

    @GetMapping("/tables")
    public String getToys(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Столы");
        model.addAttribute("items", list);
        list.stream().forEach(i -> i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list = TimeHelper.getTime(list);
        return "allItem";
    }

    @GetMapping("/phones")
    public String getPhone(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Телефоны");
        model.addAttribute("items", list);
        list.stream().forEach(i->i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list= TimeHelper.getTime(list);
        return "allItem";
    }

    @GetMapping("/foryou")
    public String getForYou(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Для себя");
        model.addAttribute("items", list);
        list.stream().forEach(i->i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list= TimeHelper.getTime(list);
        return "allItem";
    }
}
