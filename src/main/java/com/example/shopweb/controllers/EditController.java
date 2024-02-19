package com.example.shopweb.controllers;

import com.example.shopweb.models.ItemModel;
import com.example.shopweb.repos.ItemRepo;
import com.example.shopweb.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/edit")
public class EditController {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    FireBaseService fireBaseService;


    @GetMapping("/{id}")
    public String getEdit(Model model, @PathVariable long id) {
        ItemModel itemModel = itemRepo.findById(id);
        itemModel.setUrl(fireBaseService.getUrl(itemModel.getUrl()));
        model.addAttribute("item", itemModel);
        return "edit";
    }

    @PostMapping("/{id}")
    public RedirectView setChanges(@PathVariable long id,
                                   @RequestParam String name,
                                   @RequestParam double price,
                                   @RequestParam String disc,
                                   @RequestParam String url) {
        ItemModel itemModel = itemRepo.findById(id);
        itemModel.setName(name);
        itemModel.setDisc(disc);
        itemModel.setPrice(price);
        itemModel.setUrl(url);
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}
