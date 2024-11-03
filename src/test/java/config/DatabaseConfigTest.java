// src/test/java/config/DatabaseConfigTest.java
package config;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConfigTest {

    @Test
    public void testConnection() {
        try (Connection conn = DatabaseConfig.getConnection()) {
            assertNotNull(conn, "Подключение к базе данных должно быть установлено");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
