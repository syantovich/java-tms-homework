package org.syantovich.hometask39thymeleaf.controllers;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.syantovich.hometask39thymeleaf.dto.ProductDto;
import org.syantovich.hometask39thymeleaf.dto.SearchDto;
import org.syantovich.hometask39thymeleaf.entities.Product;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;
import org.syantovich.hometask39thymeleaf.mappers.ProductMapper;
import org.syantovich.hometask39thymeleaf.services.ProductsService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductsService productsService;
    private final ProductMapper productMapper;

    @GetMapping
    public String getProducts(SearchDto searchDto, Model model) {
        List<ProductDto> productDtos = productMapper.toProductDtoList(productsService.getAllProducts());

        if (productDtos.isEmpty()) {
            return "redirect:/products/add";
        }

        model.addAttribute("searchDto", searchDto);

        model.addAttribute("products", productDtos);
        return "products";
    }

    @GetMapping("/search")
    public String searchProducts(SearchDto searchDto, Model model) {
        List<ProductDto> productDtos = productMapper.toProductDtoList(productsService.getAllProducts(searchDto));
        model.addAttribute("searchDto", searchDto);
        model.addAttribute("products", productDtos);
        return "products";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable UUID id, Model model) {
        ProductDto product = productMapper.toProductDto(productsService.getProductById(id));
        System.out.println(product.getStatus().toString());
        model.addAttribute("product", product);
        model.addAttribute("isEdit", true);
        return "product-form";
    }

    @GetMapping("/{id}/set-status/{status}")
    public String deleteProduct(@PathVariable UUID id, @PathVariable ProductStatus status, Model model) {
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
    public String addProduct(ProductDto product, Model model) {
        productsService.saveProduct(productMapper.toProduct(product));
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String editProduct(ProductDto product, Model model) {
        Product currProduct = productsService.getProductById(product.getUuid());
        if (currProduct != null) {
            currProduct.setPrice(product.getPrice());
            currProduct.setStatus(product.getStatus());
            currProduct.setDescription(product.getDescription());
            currProduct.setName(product.getName());
            currProduct.setCount(product.getCount());
            currProduct.setIsDeliverable(product.getIsDeliverable());
        }

        productsService.saveProduct(currProduct);
        return "redirect:/products";
    }
}
