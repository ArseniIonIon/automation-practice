package com.automation_practice.browsers;

import com.automation_practice.utils.PropertyParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {
    private static WebDriver instance;

    private Driver() {
    }

    public static WebDriver getInstance()  {
        PropertyParser propertyParser = new PropertyParser();
        String browsType = propertyParser.getProps("browser");
        if(Objects.isNull(instance)) {
            if("Chrome".equalsIgnoreCase(browsType)){
                System.setProperty(propertyParser.getProps("chrome_property"), propertyParser.getProps("chrome_path"));
                instance =  new ChromeDriver();
            } else if ("Firefox".equalsIgnoreCase(browsType)){
                System.setProperty(propertyParser.getProps("firefox_property"), propertyParser.getProps("firefox_path"));
                instance =  new FirefoxDriver();
            }
            else throw new RuntimeException("No such driver");
            instance.manage().window().maximize();
        }
        return instance;
    }

    public static void quit(){
        instance.quit();
        instance = null;
    }
}
