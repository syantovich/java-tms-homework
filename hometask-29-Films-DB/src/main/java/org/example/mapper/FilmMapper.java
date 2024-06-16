package org.example.mapper;

import org.example.Film;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FilmMapper {
    public Film map(ResultSet rs) {
        try {
            UUID uuid = rs.getObject("id", UUID.class);
            String name = rs.getString("name");
            String description = rs.getString("description");
            int year = rs.getInt("year");
            boolean isViewed = rs.getBoolean("is_viewed");
            Film film = new Film();
            film.setUuid(uuid);
            film.setFilmName(name);
            film.setDescription(description);
            film.setYear(year);
            film.setViewed(isViewed);
            return film;
        } catch (Exception e) {
            return null;
        }

    }

    public List<Film> maps(ResultSet rs) throws SQLException {
        List<Film> films = new ArrayList<>();
        while (rs.next()) {
            Film film = map(rs);
            if (film != null) {
                films.add(map(rs));
            }
        }

        return films;
    }
}
