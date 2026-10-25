package com.stylesstock.stylestock.config;

import com.stylesstock.stylestock.model.Brand;
import com.stylesstock.stylestock.model.Category;
import com.stylesstock.stylestock.model.DistributionCentre;
import com.stylesstock.stylestock.model.Product;
import com.stylesstock.stylestock.model.Supplier;
import com.stylesstock.stylestock.repository.BrandRepository;
import com.stylesstock.stylestock.repository.CategoryRepository;
import com.stylesstock.stylestock.repository.DistributionCentreRepository;
import com.stylesstock.stylestock.repository.ProductRepository;
import com.stylesstock.stylestock.repository.SupplierRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**
 * Converts the IDs posted by HTML select controls into their corresponding JPA entities.
 */
@Configuration
public class EntityConverters {
    @Bean
    public Converter<String, Brand> brandConverter(BrandRepository repository) {
        return new Converter<>() {
            @Override
            public Brand convert(String id) {
                return id == null || id.isBlank() ? null : repository.findById(Long.valueOf(id)).orElse(null);
            }
        };
    }

    @Bean
    public Converter<String, Category> categoryConverter(CategoryRepository repository) {
        return new Converter<>() {
            @Override
            public Category convert(String id) {
                return id == null || id.isBlank() ? null : repository.findById(Long.valueOf(id)).orElse(null);
            }
        };
    }

    @Bean
    public Converter<String, Supplier> supplierConverter(SupplierRepository repository) {
        return new Converter<>() {
            @Override
            public Supplier convert(String id) {
                return id == null || id.isBlank() ? null : repository.findById(Long.valueOf(id)).orElse(null);
            }
        };
    }

    @Bean
    public Converter<String, Product> productConverter(ProductRepository repository) {
        return new Converter<>() {
            @Override
            public Product convert(String id) {
                return id == null || id.isBlank() ? null : repository.findById(Long.valueOf(id)).orElse(null);
            }
        };
    }

    @Bean
    public Converter<String, DistributionCentre> centreConverter(DistributionCentreRepository repository) {
        return new Converter<>() {
            @Override
            public DistributionCentre convert(String id) {
                return id == null || id.isBlank() ? null : repository.findById(Long.valueOf(id)).orElse(null);
            }
        };
    }
}
