package com.stylesstock.stylestock.controller;

import com.stylesstock.stylestock.repository.InventoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryRepository inventories;
    public InventoryController(InventoryRepository inventories) { this.inventories = inventories; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("inventories", inventories.findAll());
        return "inventory/list";
    }
}
