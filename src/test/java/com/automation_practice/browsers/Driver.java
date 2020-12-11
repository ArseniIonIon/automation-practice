package com.automation_practice.browsers;

import com.automation_practice.steps.LoginSteps;
import com.automation_practice.utils.PropertyParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Driver {
    private static WebDriver instance;

    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    private Driver() {
    }

    public static WebDriver getInstance() {
        PropertyParser propertyParser = new PropertyParser();
        String browsType = propertyParser.getProps("browser");
        if (Objects.isNull(instance)) {
            if ("Chrome".equalsIgnoreCase(browsType)) {
                System.setProperty(propertyParser.getProps("chrome_property"), propertyParser.getProps("chrome_path"));
                instance = new ChromeDriver();
                logger.info("Chrome browser is instantiated");
            } else if ("Firefox".equalsIgnoreCase(browsType)) {
                System.setProperty(propertyParser.getProps("firefox_property"), propertyParser.getProps("firefox_path"));
                instance = new FirefoxDriver();
                logger.info("Firefox browser is instantiated");
            } else {
                throw new RuntimeException("No such driver");
            }
            instance.manage().window().maximize();
        }
        return instance;
    }

    public static void quit() {
        instance.quit();
        logger.info("Close Browser");
        instance = null;
    }
}
