package com.example.shopweb.controllers;

import com.example.shopweb.helpers.TimeHelper;
import com.example.shopweb.models.ItemModel;
import com.example.shopweb.models.RequestModel;
import com.example.shopweb.repos.ItemRepo;
import com.example.shopweb.repos.RequestRepo;
import com.example.shopweb.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    RequestRepo requestRepo;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    FireBaseService fireBaseService;

    @GetMapping
    public String detAdmin(){
        return "admin";
    }

    @GetMapping("/edit")
    public String getAll(Model model){

        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("items", list);
        list.stream().forEach(i->i.setUrl(fireBaseService.getUrl(i.getUrl())));
        list= TimeHelper.getTime(list);
        return "editItems";
    }

    @GetMapping("/req")
    public String getPage(Model model){
        List<RequestModel> list = requestRepo.findAll();
        model.addAttribute("req", list);
        return "requests";
    }
}
