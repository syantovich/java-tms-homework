package org.syantovich.hometask39thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.syantovich.hometask39thymeleaf.entities.Product;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Product, UUID> {
    @Override
    <S extends Product> S save(S entity);

    @Override
    Optional<Product> findById(UUID aLong);

    @Override
    List<Product> findAll();
}
