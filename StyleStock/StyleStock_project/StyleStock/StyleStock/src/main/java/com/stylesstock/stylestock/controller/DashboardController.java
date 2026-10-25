package com.stylesstock.stylestock.controller;

import com.stylesstock.stylestock.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final ProductRepository products;
    private final InventoryRepository inventories;
    private final DistributionCentreRepository centres;
    private final StockTransferRepository transfers;

    public DashboardController(ProductRepository products, InventoryRepository inventories,
                               DistributionCentreRepository centres, StockTransferRepository transfers) {
        this.products = products; this.inventories = inventories; this.centres = centres; this.transfers = transfers;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("productCount", products.count());
        model.addAttribute("centreCount", centres.count());
        model.addAttribute("lowStockCount", inventories.findAll().stream().filter(i -> i.getQuantity() <= i.getReorderLevel()).count());
        model.addAttribute("transferCount", transfers.count());
        model.addAttribute("lowStockItems", inventories.findAll().stream().filter(i -> i.getQuantity() <= i.getReorderLevel()).toList());
        model.addAttribute("recentTransfers", transfers.findAll());
        return "dashboard";
    }
}
