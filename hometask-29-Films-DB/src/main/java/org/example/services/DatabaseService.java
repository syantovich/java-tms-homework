package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.mapper.FilmMapper;
import org.example.models.entity.Film;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final FilmMapper mapper;

    public Film getFilm(UUID uuid) {
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM films WHERE id = ?");
            ps.setObject(1, uuid);
            ResultSet rs = ps.executeQuery();

            rs.next();
            return mapper.map(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Film> getAllFilms() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from films order by name asc");
            return mapper.maps(resultSet);
        } catch (Exception ignored) {

            throw new RuntimeException(ignored);
        }
    }

    public void addFilm(Film film) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO films (id, name, description, year, is_viewed) VALUES (?,?,?,?,?)");
            preparedStatement.setObject(1, film.getUuid());
            preparedStatement.setString(2, film.getFilmName());
            preparedStatement.setString(3, film.getDescription());
            preparedStatement.setInt(4, film.getYear());
            preparedStatement.setBoolean(5, film.isViewed());
            preparedStatement.execute();
        } catch (Exception error) {
            throw new RuntimeException();
        }
    }

    public void updateFilm(Film film) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("update films set name = ?, year = ?, is_viewed = ?, description = ? where id = ?");
            preparedStatement.setString(1, film.getFilmName());
            preparedStatement.setInt(2, film.getYear());
            preparedStatement.setBoolean(3, film.isViewed());
            preparedStatement.setString(4, film.getDescription());
            preparedStatement.setObject(5, film.getUuid());

            preparedStatement.execute();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
    }

    public void deleteFilm(UUID uuid) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM films WHERE id = ?");
            preparedStatement.setObject(1, uuid);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tms_db?user=postgres&password=root");

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}

