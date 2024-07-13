package org.syantovich.hometask39thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductDto {
    private UUID uuid;
    private String name;
    private String description;
    private Double price;
    private Integer count;
    private Boolean isDeliverable;
    private ProductStatus status;
}
