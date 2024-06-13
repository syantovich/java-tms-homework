package org.example;

import org.example.mapper.FilmMapper;

import java.sql.*;
import java.util.*;

public class DatabaseService {
    private static final FilmMapper mapper = new FilmMapper();

    public Film getFilm(UUID uuid) {
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM films WHERE uuid = ?");
            ps.setObject(1, uuid);
            ResultSet rs = ps.executeQuery();

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
            throw new RuntimeException();
        }
    }

    public void addFilm(Film film) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO films (id, name, desription, year, is_viewed) VALUES (?,?,?,?,?)");
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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tms_db?user=postgres&password=root");
    }

}

