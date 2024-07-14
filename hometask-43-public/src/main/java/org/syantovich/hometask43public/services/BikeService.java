package org.syantovich.hometask43public.services;

import org.syantovich.hometask43public.dto.BikeDto;
import org.syantovich.hometask43public.dto.SearchDto;

import java.util.List;
import java.util.UUID;

public interface BikeService {

    public List<BikeDto> findAll(SearchDto searchDto);

    public BikeDto findById(UUID id);
}
