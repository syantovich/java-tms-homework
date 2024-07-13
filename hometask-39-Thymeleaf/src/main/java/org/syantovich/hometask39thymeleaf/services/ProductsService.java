package org.syantovich.hometask39thymeleaf.services;


import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.syantovich.hometask39thymeleaf.dto.SearchDto;
import org.syantovich.hometask39thymeleaf.entities.Product;
import org.syantovich.hometask39thymeleaf.repositories.ProductsRepository;

import java.util.ArrayList;
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

    public List<Product> getAllProducts(SearchDto searchDto) {
        return productsRepository.findAll(createSpecification(searchDto));
    }

    public Product getProductById(UUID id) {
        return productsRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productsRepository.save(product);
    }

    private Specification<Product> createSpecification(SearchDto searchDto) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<>();
            String name = searchDto.getName();
            Integer minCount = searchDto.getMinCount();
            Integer maxCount = searchDto.getMaxCount();
            Double minPrice = searchDto.getMinPrice();
            Double maxPrice = searchDto.getMaxPrice();
            Boolean deliverable = searchDto.getDeliverable();
            Boolean isUseDeliver = searchDto.getIsUseDeliver();

            if (name != null && !name.isEmpty()) {
                Predicate namePred = criteriaBuilder.like(root.get("name"), "%" + name + "%");
                predicates.add(namePred);
            }

            if (minCount != null) {
                Predicate minCountPred = criteriaBuilder.greaterThanOrEqualTo(root.get("count"), minCount);
                predicates.add(minCountPred);
            }

            if (maxCount != null) {
                Predicate maxCountPred = criteriaBuilder.lessThanOrEqualTo(root.get("count"), maxCount);
                predicates.add(maxCountPred);
            }

            if (minPrice != null) {
                Predicate minPricePred = criteriaBuilder.greaterThan(root.get("price"), minPrice);
                predicates.add(minPricePred);
            }

            if (maxPrice != null) {
                Predicate maxPricePred = criteriaBuilder.lessThan(root.get("price"), maxPrice);
                predicates.add(maxPricePred);
            }

            if (isUseDeliver) {
                Predicate isDeliverablePred = criteriaBuilder.equal(root.get("isDeliverable"), deliverable);
                predicates.add(isDeliverablePred);
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
