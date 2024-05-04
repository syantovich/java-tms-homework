package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ProductCategory;

import java.util.List;

@Data @AllArgsConstructor
public class Product {
    private String name;
    private int price;
    private ProductCategory category;
    private boolean isDeliverable;
    private List<Shop> shops;
    private Manufacturer manufacturer;
}
