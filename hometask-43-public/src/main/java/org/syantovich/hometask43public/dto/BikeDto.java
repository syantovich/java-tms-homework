package org.syantovich.hometask43public.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BikeDto {
    private UUID id;
    private Integer num;
    private Brands brand;
    private Types type;

    public enum Brands {
        STEELS,
        AIST,
        GIANT,
        SCOTT,
        FUJI
    }

    public enum Types {
        BMX,
        HYBRID,
        MTB,
        RIGID,
        TOURING
    }
}
