package org.syantovich.hometask43bike.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.syantovich.hometask43bike.dto.BikeDto;
import org.syantovich.hometask43bike.dto.SearchDto;
import org.syantovich.hometask43bike.services.BikeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bikes")
public class BikeController {
    private final BikeService bikeService;

    @GetMapping
    public List<BikeDto> getBikes(SearchDto searchDto) {
        return bikeService.findAll(searchDto);
    }

    @GetMapping("/{id}")
    public BikeDto findBikeById(@PathVariable UUID id) {
        return bikeService.getBikeById(id);
    }

    @PostMapping
    public BikeDto addBike(@RequestBody BikeDto bikeDto) {
        return bikeService.save(bikeDto);
    }

    @PutMapping("/{id}")
    public BikeDto updateBike(@PathVariable UUID id, @RequestBody BikeDto bikeDto) {
        return bikeService.update(id, bikeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable UUID id) {
        bikeService.delete(id);
    }

}
