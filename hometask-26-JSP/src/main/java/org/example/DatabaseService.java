package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class DatabaseService {
    private static ArrayList<Film> films = new ArrayList<>();

    static {
        films.add(new Film("Titanic", "titanic desc", 1922, false));
        films.add(new Film("Iron Man", "iron man history", 2001, true));
    }

    public Film getFilm(UUID uuid) throws FilmError {
        return films.stream().filter(f -> f.getUuid().equals(uuid)).findFirst().orElseThrow(() -> new FilmError(ErrorCodes.GET));
    }

    public ArrayList<Film> getAllFilms() {
        return films;
    }

    public void addFilm(Film film) throws FilmError {
        try {
            films.add(film);
        } catch (Exception error) {
            throw new FilmError(ErrorCodes.ADD);
        }
    }

    public void updateFilm(Film film) throws FilmError {
        Film oldFilm = films.stream().filter(f -> f.getUuid().equals(film.getUuid())).findFirst().orElseThrow(() -> new FilmError(ErrorCodes.UPDATE));
        oldFilm.setDescription(film.getDescription());
        oldFilm.setYear(film.getYear());
        oldFilm.setFilmName(film.getFilmName());
        oldFilm.setViewed(film.isViewed());
    }

    public void deleteFilm(UUID uuid) throws FilmError {
        films = films.stream().filter(f -> !f.getUuid().equals(uuid)).collect(Collectors
                .toCollection(ArrayList::new));
    }

}

