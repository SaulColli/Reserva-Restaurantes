package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader() {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error al cargar archivo de configuración: " + e.getMessage());
        }
    }

    public String getenv(String envName) {
        return properties.getProperty(envName);
    }
}
