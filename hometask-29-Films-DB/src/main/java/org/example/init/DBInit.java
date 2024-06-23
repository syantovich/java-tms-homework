package org.example.init;

import lombok.RequiredArgsConstructor;
import org.postgresql.Driver;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@RequiredArgsConstructor
public class DBInit {
    public void init() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = getConnection()) {
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

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tms_db?user=postgres&password=root");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
