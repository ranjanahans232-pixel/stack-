package com.stylesstock.stylestock.controller;

import com.stylesstock.stylestock.model.StockTransfer;
import com.stylesstock.stylestock.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;

@Controller
@RequestMapping("/transfers")
public class TransferController {
    private final StockTransferRepository transfers;
    private final ProductRepository products;
    private final DistributionCentreRepository centres;

    public TransferController(StockTransferRepository transfers, ProductRepository products,
                              DistributionCentreRepository centres) {
        this.transfers = transfers; this.products = products; this.centres = centres;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("transfers", transfers.findAll());
        return "transfers/list";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("transfer", new StockTransfer());
        model.addAttribute("products", products.findAll());
        model.addAttribute("centres", centres.findAll());
        return "transfers/form";
    }

    @PostMapping
    public String create(@ModelAttribute StockTransfer transfer, RedirectAttributes redirect) {
        if (transfer.getSourceCentre() != null && transfer.getDestinationCentre() != null
                && transfer.getSourceCentre().getCentreId().equals(transfer.getDestinationCentre().getCentreId())) {
            redirect.addFlashAttribute("errorMessage", "Source and destination centres must be different.");
            return "redirect:/transfers/new";
        }
        transfer.setTransferDate(LocalDate.now());
        transfer.setStatus(StockTransfer.TransferStatus.PENDING);
        transfers.save(transfer);
        redirect.addFlashAttribute("successMessage", "Transfer request created.");
        return "redirect:/transfers";
    }
}
