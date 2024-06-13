package org.example.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private UUID uuid;
    private String filmName;
    private String description;
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
