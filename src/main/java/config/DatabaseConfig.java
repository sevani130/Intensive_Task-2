// src/main/java/config/DatabaseConfig.java
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Properties props = new Properties();
            props.load(DatabaseConfig.class.getClassLoader().getResourceAsStream("database.properties"));
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");

            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки конфигурации базы данных", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
