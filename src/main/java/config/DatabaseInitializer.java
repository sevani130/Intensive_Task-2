// src/main/java/config/DatabaseInitializer.java
package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement()) {

            // Создание таблицы Users
            String sql = "CREATE TABLE IF NOT EXISTS Users (id SERIAL PRIMARY KEY, name VARCHAR(100))";
            statement.executeUpdate(sql);

            // Другие запросы...
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при инициализации базы данных", e);
        }
    }
}

