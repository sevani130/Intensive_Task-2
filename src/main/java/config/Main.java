package config;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();
        System.out.println("Инициализация завершена");
    }
}
