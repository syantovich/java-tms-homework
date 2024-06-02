package org.example.init;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.example.DatabaseService;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/postgreInit", loadOnStartup = 1)
public class DBInit extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DatabaseService.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists films (\n" +
                    "    id uuid primary key,\n" +
                    "    name varchar,\n" +
                    "    description text,\n" +
                    "    year int,\n" +
                    "    is_viewed boolean\n" +
                    ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
