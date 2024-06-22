package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.entities.OrderEntity;
import org.example.entities.ProductEntity;
import org.example.services.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping
    public String addProduct(@RequestParam(name = "name") String name, @RequestParam(name = "description", required = false) String description, @RequestParam(name = "price") Double price) {

        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        productsService.saveProduct(product);
        System.out.println("Adding product: " + product);
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") String uuid) {
        productsService.deleteProduct(UUID.fromString(uuid));
        return "";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable(name = "id") String uuid) {
        ProductEntity product = productsService.findById(UUID.fromString(uuid));

        System.out.println(product);
        return "";
    }
}
