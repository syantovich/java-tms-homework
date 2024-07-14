package org.syantovich.hometask43public.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.syantovich.hometask43public.dto.BikeDto;
import org.syantovich.hometask43public.dto.SearchDto;

import java.util.List;
import java.util.UUID;

@Component
@FeignClient(name = "bikeClient", url = "http://localhost:8081", path = "/bikes")
public interface BikeClient {
    @GetMapping()
    List<BikeDto> getBikes(
            @RequestParam(name = "isHidden") Boolean isHidden,
            @RequestParam(name = "isBooked") Boolean isBooked,
            @RequestParam(name = "type") String type,
            @RequestParam(name = "brand") String brand,
            @RequestParam(name = "num") Integer num,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize
    );

    @GetMapping("/{id}")
    BikeDto findBikeById(@PathVariable UUID id);
}
