package org.syantovich.hometask39thymeleaf.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.syantovich.hometask39thymeleaf.entities.Product;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;
import org.syantovich.hometask39thymeleaf.services.ProductsService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductsService productsService;
    @GetMapping
    public String getProducts(Model model) {
        List<Product> nonDeletedProducts = productsService.getAllProducts();

        if(nonDeletedProducts.isEmpty()) {
            return "redirect:/products/add";
        }

        model.addAttribute("products", nonDeletedProducts);
        return "products";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable UUID id, Model model) {
        Product product = productsService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("isEdit", true);
        return "product-form";
    }

    @GetMapping("/{id}/set-status/{status}")
    public String deleteProduct(@PathVariable UUID id,@PathVariable ProductStatus status, Model model) {
        Product product = productsService.getProductById(id);
        product.setStatus(status);
        productsService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("isEdit", false);
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping("/add")
    public String addProduct(Product product, Model model) {
        productsService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, Model model) {
        Product currProduct = productsService.getProductById(product.getUuid());
        if(currProduct != null){
            currProduct.setStatus(product.getStatus());
            currProduct.setPrice(product.getPrice());
            currProduct.setDescription(product.getDescription());
            currProduct.setName(product.getName());
        }
        productsService.saveProduct(currProduct);
        return "redirect:/products";
    }
}
