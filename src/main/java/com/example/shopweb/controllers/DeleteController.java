package com.example.shopweb.controllers;


import com.example.shopweb.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    ItemRepo itemRepo;

    @GetMapping("/{id}")
    public RedirectView delete(@PathVariable long id){
        itemRepo.deleteById(id);
        return new RedirectView("/admin/edit");
    }
}
