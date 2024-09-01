package org.example.hometask53.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto{
    private String phoneNumber;
    private int cinemaId;
    private int sessionId;
    private int placeId;
}
