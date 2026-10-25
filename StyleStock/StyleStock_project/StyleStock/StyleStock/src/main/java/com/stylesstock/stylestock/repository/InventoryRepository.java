package com.stylesstock.stylestock.repository;

import com.stylesstock.stylestock.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
