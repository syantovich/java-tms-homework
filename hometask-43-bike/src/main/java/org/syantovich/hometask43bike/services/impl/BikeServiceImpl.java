package org.syantovich.hometask43bike.services.impl;

import jakarta.persistence.criteria.Predicate;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.syantovich.hometask43bike.domain.BikeEntity;
import org.syantovich.hometask43bike.dto.BikeDto;
import org.syantovich.hometask43bike.dto.SearchDto;
import org.syantovich.hometask43bike.exc.CommonException;
import org.syantovich.hometask43bike.mappers.BikeMapper;
import org.syantovich.hometask43bike.repository.BikeRepository;
import org.syantovich.hometask43bike.services.BikeService;
import org.syantovich.hometask43bike.specif.BikeSpecification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {
    private final BikeSpecification bikeSpecification;
    private final BikeRepository bikeRepository;
    private final BikeMapper bikeMapper;

    @Override
    public List<BikeDto> findAll(SearchDto searchDto) {
        Integer page = searchDto.getPage();
        Integer pageSize = searchDto.getPageSize();

        Specification<BikeEntity> globalSpecification = bikeSpecification.createGlobalSpecification(searchDto);

        if (page != null && page > 0) {
            return bikeMapper.toListBikeDto(bikeRepository.findAll(
                    globalSpecification,
                    PageRequest.of(page - 1, pageSize, Sort.by("num"))
            ).getContent());
        } else {
            List<BikeEntity> all = bikeRepository.findAll(globalSpecification);
            return bikeMapper.toListBikeDto(all);
        }

    }


    @Override
    public BikeDto getBikeById(UUID id) {
        Optional<BikeEntity> bike = bikeRepository.findById(id);

        if (bike != null && bike.isPresent()) {
            return bikeMapper.toBikeDto(bike.get());
        }
        throw new CommonException(404, "Bike not found");
    }

    @Override
    public BikeDto save(BikeDto bikeDto) {
        BikeEntity entity = bikeMapper.toBike(bikeDto);

        if (bikeRepository.existsByNum(entity.getNum())) {
            throw new CommonException(409, "Bike already exists");
        }

        BikeEntity save = bikeRepository.save(entity);

        return bikeMapper.toBikeDto(save);
    }

    @Override
    @Transactional
    public BikeDto update(UUID id, BikeDto bikeDto) {
        BikeEntity newEntity = bikeMapper.toBike(bikeDto);
        Optional<BikeEntity> bikeOpt = bikeRepository.findById(id);

        if (bikeOpt.isEmpty()) {
            throw new CommonException(404, "Bike not found");
        }

        BikeEntity bikeEntity = bikeOpt.get();

        if (!bikeEntity.getNum().equals(newEntity.getNum())) {
            if (bikeRepository.existsByNum(newEntity.getNum())) {
                throw new CommonException(409, "Bike already exists");
            }
        }

        bikeMapper.update(bikeEntity, newEntity);
        return null;
    }

    @Override
    public void delete(UUID id) {
        bikeRepository.findById(id).ifPresentOrElse(bikeRepository::delete, () -> {
            throw new CommonException(404, "Bike not found");
        });

    }
}
