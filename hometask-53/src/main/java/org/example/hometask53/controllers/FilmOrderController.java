package org.example.hometask53.controllers;

import lombok.RequiredArgsConstructor;
import org.example.hometask53.client.FilmSessionClient;
import org.example.hometask53.dto.CreateOrderDto;
import org.example.hometask53.dto.FilmSessionOrderInfoDto;
import org.example.hometask53.dto.OrderDto;
import org.example.hometask53.dto.PlaceStatusDto;
import org.example.hometask53.exp.BookError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class FilmOrderController {
    private final FilmSessionClient filmSessionClient;

    @PostMapping
    public ResponseEntity<OrderDto> orderFilm(@RequestBody CreateOrderDto createOrderDto) throws BookError {
        FilmSessionOrderInfoDto filmSessionOrderInfoDto = new FilmSessionOrderInfoDto();
        filmSessionOrderInfoDto.setCinemaId(createOrderDto.getCinemaId());
        filmSessionOrderInfoDto.setSessionId(createOrderDto.getSessionId());
        filmSessionOrderInfoDto.setPlaceId(createOrderDto.getPlaceId());

        ResponseEntity<PlaceStatusDto> placeStatusDtoResponseEntity = filmSessionClient.checkPlace(filmSessionOrderInfoDto);
        PlaceStatusDto placeStatusDto = placeStatusDtoResponseEntity.getBody();

        if (placeStatusDtoResponseEntity.getStatusCode().is2xxSuccessful()
                && placeStatusDto != null
                && placeStatusDto.isFree()) {
            // Сохранение заказа
            OrderDto orderDto = new OrderDto();
            orderDto.setId(UUID.randomUUID());
            orderDto.setCinemaId(createOrderDto.getCinemaId());
            orderDto.setSessionId(createOrderDto.getSessionId());
            orderDto.setPlaceId(createOrderDto.getPlaceId());
            return ResponseEntity.ok(orderDto);
        }
        throw new BookError("The place is already booked");

    }
}
