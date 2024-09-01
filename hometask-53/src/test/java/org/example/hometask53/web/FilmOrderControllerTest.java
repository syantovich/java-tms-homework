package org.example.hometask53.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.example.hometask53.dto.CreateOrderDto;
import org.example.hometask53.dto.PlaceStatusDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FilmOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @RegisterExtension
    static WireMockExtension WIREMOCK = WireMockExtension.newInstance()
            .options(WireMockConfiguration.options().port(8081))
            .build();

    @Value("classpath:data/json/create-order.json")
    private File createOrderFile;

    @Value("classpath:data/json/film-order-check-false.json")
    private File checkOrderFalseFile;

    @Value("classpath:data/json/film-order-check-true.json")
    private File checkOrderTrueFile;

    @Test
    void createOrderTestSuccess() throws Exception {
        PlaceStatusDto placeStatusDto = mapper.readValue(checkOrderTrueFile, PlaceStatusDto.class);
        String placeStatusDtoJson = mapper.writeValueAsString(placeStatusDto);

        WIREMOCK.stubFor(WireMock.post("/session/check-place")
                .willReturn(WireMock.ok().withBody(placeStatusDtoJson).withHeader("Content-Type", "application/json")));

        CreateOrderDto createOrderDto = mapper.readValue(createOrderFile, CreateOrderDto.class);
        String createOrderDtoJson = mapper.writeValueAsString(createOrderDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createOrderDtoJson)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void createOrderTestPlaceAlreadyBooked() throws Exception {
        PlaceStatusDto placeStatusDto = mapper.readValue(checkOrderFalseFile, PlaceStatusDto.class);
        String placeStatusDtoJson = mapper.writeValueAsString(placeStatusDto);

        WIREMOCK.stubFor(WireMock.post("/session/check-place")
                .willReturn(WireMock.ok().withBody(placeStatusDtoJson).withHeader("Content-Type", "application/json")));

        CreateOrderDto createOrderDto = mapper.readValue(createOrderFile, CreateOrderDto.class);
        String createOrderDtoJson = mapper.writeValueAsString(createOrderDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createOrderDtoJson)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void createOrderTestPlaceBadRequest() throws Exception {
        PlaceStatusDto placeStatusDto = mapper.readValue(checkOrderFalseFile, PlaceStatusDto.class);
        String placeStatusDtoJson = mapper.writeValueAsString(placeStatusDto);

        WIREMOCK.stubFor(WireMock.post("/session/check-place")
                .willReturn(WireMock.badRequest().withBody(placeStatusDtoJson).withHeader("Content-Type", "application/json")));

        CreateOrderDto createOrderDto = mapper.readValue(createOrderFile, CreateOrderDto.class);
        String createOrderDtoJson = mapper.writeValueAsString(createOrderDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createOrderDtoJson)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}