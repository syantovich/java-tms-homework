package org.syantovich.hometask43bike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.syantovich.hometask43bike.domain.BikeEntity;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BikeDto {
    private UUID id;
    private Integer num;
    private BikeEntity.Brands brand;
    private BikeEntity.Types type;
    private Boolean isHidden;
    private Boolean isBooked;
}
