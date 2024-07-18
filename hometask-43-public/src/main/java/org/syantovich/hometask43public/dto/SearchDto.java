package org.syantovich.hometask43public.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SearchDto extends PaginationDto {
    private Integer num;
    private String type;
    private String brand;
    private Boolean isHidden;
    private Boolean isBooked;
}
