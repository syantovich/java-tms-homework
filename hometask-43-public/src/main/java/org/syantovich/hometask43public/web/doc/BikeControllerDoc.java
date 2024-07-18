package org.syantovich.hometask43public.web.doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.syantovich.hometask43public.dto.BikeDto;
import org.syantovich.hometask43public.dto.ErrorDto;
import org.syantovich.hometask43public.dto.SearchDto;

import java.util.List;
import java.util.UUID;

public interface BikeControllerDoc {
    @Operation(
            tags = "Bike",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bikes was successfully gotten",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = BikeDto.class))))
            })
    List<BikeDto> getBikes(SearchDto searchDto);

    @Operation(
            tags = "Bike",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bike was successfully gotten",
                            content = @Content(schema = @Schema(implementation = BikeDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "User not found",
                            content = @Content(schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    BikeDto getBikeById(@PathVariable UUID id);
}
