package org.syantovich.hometask43bike.specif;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.syantovich.hometask43bike.domain.BikeEntity;
import org.syantovich.hometask43bike.dto.SearchDto;

import java.util.ArrayList;

@Service
public class BikeSpecification {
    public Specification<BikeEntity> createGlobalSpecification(SearchDto searchDto) {
        return (root, query, criteriaBuilder) -> {

            var predicates = new ArrayList<>();

            Integer num = searchDto.getNum();
            String brand = searchDto.getBrand();
            String type = searchDto.getType();
            Boolean isHiddenValue = searchDto.getIsHidden();
            Boolean isBookedValue = searchDto.getIsBooked();

            if (num != null && num > 0) {
                predicates.add(criteriaBuilder.equal(root.get("num"), num));
            }

            if (brand != null && !brand.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("brand"), "%" + brand + "%"));
            }

            if (type != null && !type.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("type"), "%" + type + "%"));
            }

            if (isHiddenValue != null) {
                predicates.add(criteriaBuilder.equal(root.get("isHidden"), isHiddenValue));
            }

            if (isBookedValue != null) {
                predicates.add(criteriaBuilder.equal(root.get("isBooked"), isBookedValue));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));

        };
    }
}
