package org.syantovich.hometask43bike.services;

import org.syantovich.hometask43bike.dto.BikeDto;
import org.syantovich.hometask43bike.dto.SearchDto;

import java.util.List;
import java.util.UUID;

public interface BikeService {

    public List<BikeDto> findAll(SearchDto searchDto);

    public BikeDto getBikeById(UUID id);

    public BikeDto save(BikeDto bikeDto);

    public BikeDto update(UUID id, BikeDto bikeDto);

    public void delete(UUID bikeDto);
}
