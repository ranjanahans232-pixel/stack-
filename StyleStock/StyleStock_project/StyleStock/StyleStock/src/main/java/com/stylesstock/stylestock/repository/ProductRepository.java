package com.stylesstock.stylestock.repository;

import com.stylesstock.stylestock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
