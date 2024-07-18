package org.syantovich.hometask43bike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationDto {
    private Integer page;
    private Integer pageSize = 10;
}
