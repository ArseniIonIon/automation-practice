package com.automation_practice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertyParser {
    private final String CONFIG_PROPERTIES_FILE_NAME = "config.properties";
    private Properties property = new Properties();

    public String getProps(String key) {
        InputStream inputStream =null;

        try{
            inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES_FILE_NAME);

            if(Objects.nonNull(inputStream)){
                property.load(inputStream);
            } else {
                throw new RuntimeException("property file ' " + CONFIG_PROPERTIES_FILE_NAME
                        + " ' not found in the classpath");
            }
        } catch ( IOException e){
            System.out.println("Exception: " + e);
            throw new RuntimeException("Property file was not read.");
        } finally {
            try {
                if (Objects.nonNull(inputStream)) inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Could not close input stream");
            }
        }
        return property.getProperty(key);
    }

}