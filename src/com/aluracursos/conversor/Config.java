package com.aluracursos.conversor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "config.properties";

    public static String getApiKey() {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
            return props.getProperty("API_KEY");
        } catch (IOException e) {
            System.out.println("Error leyendo la API key.");
            return null;
        }
    }
}
