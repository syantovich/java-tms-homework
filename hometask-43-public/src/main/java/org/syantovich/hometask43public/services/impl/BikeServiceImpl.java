package org.syantovich.hometask43public.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.syantovich.hometask43public.client.BikeClient;
import org.syantovich.hometask43public.dto.BikeDto;
import org.syantovich.hometask43public.dto.SearchDto;
import org.syantovich.hometask43public.services.BikeService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {
    private final BikeClient bikeClient;

    @Override
    public List<BikeDto> findAll(SearchDto searchDto) {
        searchDto.setIsBooked(false);
        searchDto.setIsHidden(false);
        return bikeClient.getBikes(
                searchDto.getIsHidden(),
                searchDto.getIsBooked(),
                searchDto.getType(),
                searchDto.getBrand(),
                searchDto.getNum(),
                searchDto.getPage(),
                searchDto.getPageSize());
    }


    @Override
    public BikeDto findById(UUID id) {
        return bikeClient.findBikeById(id);
    }

}