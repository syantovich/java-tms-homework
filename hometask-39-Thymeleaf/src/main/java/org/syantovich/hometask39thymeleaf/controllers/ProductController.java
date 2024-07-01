package org.syantovich.hometask39thymeleaf.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.syantovich.hometask39thymeleaf.entities.Product;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;
import org.syantovich.hometask39thymeleaf.services.ProductsService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductsService productsService;
    @GetMapping
    public String getProducts(Model model) {
        List<Product> nonDeletedProducts = productsService.getNonDeletedProducts();

        model.addAttribute("products", nonDeletedProducts);

        List<String> buttonsNames = List.of("Edit", "Delete");
        model.addAttribute("buttons", buttonsNames);
        return "products";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable UUID id, Model model) {
        Product product = productsService.getProductById(id);
        model.addAttribute("product", product);
        return "";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable UUID id, Model model) {
        Product product = productsService.getProductById(id);
        product.setStatus(ProductStatus.DELETED);
        productsService.saveProduct(product);
        return "redirect:/products";
    }
}
