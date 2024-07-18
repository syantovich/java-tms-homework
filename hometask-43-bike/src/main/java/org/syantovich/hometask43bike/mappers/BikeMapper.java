package org.syantovich.hometask43bike.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.syantovich.hometask43bike.domain.BikeEntity;
import org.syantovich.hometask43bike.dto.BikeDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeMapper {
    public BikeEntity toBike(BikeDto bikeDto);
    public BikeDto toBikeDto(BikeEntity bikeEntity);

    public List<BikeDto> toListBikeDto(List<BikeEntity> bikeEntities);
    public List<BikeEntity> toListBikeEntity(List<BikeDto> bikeDtos);

    void update(@MappingTarget BikeEntity target, BikeEntity newBike);
}
