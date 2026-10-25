package com.stylesstock.stylestock.controller;

import com.stylesstock.stylestock.model.Product;
import com.stylesstock.stylestock.repository.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository products;
    private final BrandRepository brands;
    private final CategoryRepository categories;
    private final SupplierRepository suppliers;

    public ProductController(ProductRepository products, BrandRepository brands,
                             CategoryRepository categories, SupplierRepository suppliers) {
        this.products = products; this.brands = brands; this.categories = categories; this.suppliers = suppliers;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String q, Model model) {
        var all = products.findAll();
        if (q != null && !q.isBlank()) {
            String term = q.toLowerCase();
            all = all.stream().filter(p -> p.getProductName().toLowerCase().contains(term)
                    || p.getSku().toLowerCase().contains(term)).toList();
        }
        model.addAttribute("products", all);
        model.addAttribute("q", q == null ? "" : q);
        return "products/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        addDropdowns(model);
        return "products/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Product product, BindingResult result, Model model,
                         RedirectAttributes redirect) {
        if (result.hasErrors()) { addDropdowns(model); return "products/form"; }
        try {
            products.save(product);
            redirect.addFlashAttribute("successMessage", "Product created successfully.");
            return "redirect:/products";
        } catch (Exception ex) {
            result.rejectValue("sku", "duplicate", "SKU must be unique.");
            addDropdowns(model);
            return "products/form";
        }
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", products.findById(id).orElseThrow());
        addDropdowns(model);
        return "products/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Product product,
                         BindingResult result, Model model, RedirectAttributes redirect) {
        if (result.hasErrors()) { addDropdowns(model); return "products/form"; }
        product.setProductId(id);
        products.save(product);
        redirect.addFlashAttribute("successMessage", "Product updated successfully.");
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (products.existsById(id)) {
            try { products.deleteById(id); redirect.addFlashAttribute("successMessage", "Product deleted."); }
            catch (Exception ex) { redirect.addFlashAttribute("errorMessage", "Cannot delete a product that has inventory or transfers."); }
        }
        return "redirect:/products";
    }

    private void addDropdowns(Model model) {
        model.addAttribute("brands", brands.findAll());
        model.addAttribute("categories", categories.findAll());
        model.addAttribute("suppliers", suppliers.findAll());
    }
}
