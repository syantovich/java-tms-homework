package org.example.hometask53.client;

import org.example.hometask53.config.FeignConfig;
import org.example.hometask53.dto.FilmSessionOrderInfoDto;
import org.example.hometask53.dto.PlaceStatusDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "filmSessionClient", url = "${app.clients.film-session.url}", path = "/session", configuration = FeignConfig.class)
public interface FilmSessionClient {

    @PostMapping(value = "/check-place", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlaceStatusDto> checkPlace(@RequestBody FilmSessionOrderInfoDto filmSessionOrderInfoDto);
}