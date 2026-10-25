package com.stylesstock.stylestock.repository;

import com.stylesstock.stylestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
