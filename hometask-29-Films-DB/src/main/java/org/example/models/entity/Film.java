package org.example.models.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private UUID uuid = UUID.randomUUID();
    @NotEmpty(message = "Field is required")
    @Length(min = 4, message = "Min length is 4")
    private String filmName;
    @NotEmpty(message = "Field is required")
    private String description;
    @Min(value = 1940, message = "Film need to be more than {value}")
    private int year;
    private boolean isViewed;

    public Film(String filmName, String description, int year, boolean isViewed) {
        this.filmName = filmName;
        this.uuid = UUID.randomUUID();
        this.description = description;
        this.year = year;
        this.isViewed = isViewed;
    }
}
