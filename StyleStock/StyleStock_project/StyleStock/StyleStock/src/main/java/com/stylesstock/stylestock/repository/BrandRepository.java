package com.stylesstock.stylestock.repository;

import com.stylesstock.stylestock.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
