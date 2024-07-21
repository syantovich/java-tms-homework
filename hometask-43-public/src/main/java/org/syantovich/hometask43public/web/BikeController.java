package org.syantovich.hometask43public.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.syantovich.hometask43public.dto.BikeDto;
import org.syantovich.hometask43public.dto.SearchDto;
import org.syantovich.hometask43public.services.BikeService;
import org.syantovich.hometask43public.web.doc.BikeControllerDoc;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bikes")
public class BikeController implements BikeControllerDoc {
    private final BikeService bikeService;

    @GetMapping
    public List<BikeDto> getBikes(@RequestParam(required = false) SearchDto searchDto) {

        return bikeService.findAll(searchDto);
    }

    @GetMapping("/{id}")
    public BikeDto getBikeById(@PathVariable UUID id) {
        return bikeService.findById(id);
    }


}
