package org.syantovich.hometask39thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDto {
    private String name;
    private Integer minCount = 0;
    private Integer maxCount;
    private Double minPrice = 0.0;
    private Double maxPrice;
    private Boolean isUseDeliver = false;
    private Boolean deliverable = false;
}
