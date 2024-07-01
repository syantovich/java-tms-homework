package org.syantovich.hometask39thymeleaf.services;


import jdk.jfr.Category;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.syantovich.hometask39thymeleaf.entities.Product;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;
import org.syantovich.hometask39thymeleaf.repositories.ProductsRepository;

import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productsRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productsRepository.save(product);
    }

    public List<Product> getNonDeletedProducts() {
        return productsRepository.findAllExceptStatus(ProductStatus.DELETED);
    }
}
