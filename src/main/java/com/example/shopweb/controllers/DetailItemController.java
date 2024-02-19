package com.example.shopweb.controllers;

import com.example.shopweb.helpers.ItemModelWithCurency;
import com.example.shopweb.models.ItemModel;
import com.example.shopweb.models.RequestModel;
import com.example.shopweb.repos.ItemRepo;
import com.example.shopweb.repos.RequestRepo;
import com.example.shopweb.services.CarencyService;
import com.example.shopweb.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/item")
public class DetailItemController {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CarencyService carencyService;

    @Autowired
    RequestRepo requestRepo;

    @Autowired
    private FireBaseService fireBaseService;

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id, Model model){
        ItemModel itemModel = itemRepo.findById(id);
        ItemModelWithCurency itemModelWithCurency = new ItemModelWithCurency(itemModel);
        itemModelWithCurency.setEurPrice(carencyService.getEurPrice(itemModel.getPrice()));
        itemModelWithCurency.setUsdPrice(carencyService.getUsdPrice(itemModel.getPrice()));
        model.addAttribute("item", itemModelWithCurency);
        itemModelWithCurency.setUrl(fireBaseService.getUrl(itemModelWithCurency.getUrl()));
        return "detailItem";
    }

    @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable long id, @RequestParam String name,
                                 @RequestParam String phoneNumber){
        RequestModel requestModel = new RequestModel();
        requestModel.setName(name);
        requestModel.setPhoneNumber(phoneNumber);
        requestModel.setItemId(id);
        requestRepo.save(requestModel);
        return new RedirectView("/allItems");
    }
}
