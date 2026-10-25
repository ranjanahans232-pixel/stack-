package com.stylesstock.stylestock.config;

import com.stylesstock.stylestock.model.*;
import com.stylesstock.stylestock.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seedData(BrandRepository brands, CategoryRepository categories,
                               SupplierRepository suppliers, DistributionCentreRepository centres,
                               ProductRepository products, InventoryRepository inventories) {
        return args -> {
            if (products.count() > 0) return;
            Brand brand = brands.save(new Brand("Northline", "Everyday clothing essentials"));
            Category category = categories.save(new Category("T-Shirts", "Casual tops and tees"));
            Supplier supplier = suppliers.save(new Supplier("Maple Apparel Supply", "orders@example.com", "416-555-0134"));
            DistributionCentre centre = centres.save(new DistributionCentre("Toronto Main Centre", "100 Stockroom Avenue", "Toronto"));
            Product p1 = new Product();
            p1.setProductName("Classic Cotton T-Shirt"); p1.setSku("SS-TS-001"); p1.setSize("M");
            p1.setColour("Black"); p1.setUnitPrice(new BigDecimal("19.99"));
            p1.setBrand(brand); p1.setCategory(category); p1.setSupplier(supplier);
            products.save(p1);
            Inventory inv = new Inventory(); inv.setProduct(p1); inv.setCentre(centre); inv.setQuantity(4); inv.setReorderLevel(5);
            inventories.save(inv);
            Product p2 = new Product();
            p2.setProductName("Relaxed Fit T-Shirt"); p2.setSku("SS-TS-002"); p2.setSize("L");
            p2.setColour("White"); p2.setUnitPrice(new BigDecimal("24.50"));
            p2.setBrand(brand); p2.setCategory(category); p2.setSupplier(supplier);
            products.save(p2);
            Inventory inv2 = new Inventory(); inv2.setProduct(p2); inv2.setCentre(centre); inv2.setQuantity(18); inv2.setReorderLevel(5);
            inventories.save(inv2);
        };
    }
}
