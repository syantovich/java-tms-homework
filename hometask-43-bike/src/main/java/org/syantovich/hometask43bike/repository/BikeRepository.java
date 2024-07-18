package org.syantovich.hometask43bike.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.syantovich.hometask43bike.domain.BikeEntity;

import java.util.UUID;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, UUID>, JpaSpecificationExecutor<BikeEntity>, PagingAndSortingRepository<BikeEntity, UUID> {

    boolean existsByNum(Integer num);

    Page<BikeEntity> findAll(Specification<BikeEntity> spec, Pageable pageRequest);
}
