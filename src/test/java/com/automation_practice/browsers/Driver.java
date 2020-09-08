package com.automation_practice.browsers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {

    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src\\resources\\drivers\\chrome84\\chromedriver.exe";
    private static WebDriver instance;

    private Driver(){
    }

    public static WebDriver getInstance(){
        if(Objects.isNull(instance)) {
            System.setProperty(CHROME_PROPERTY, CHROME_PATH);
            instance = new ChromeDriver();
            instance.manage().window().maximize();
        }
        return instance;
    }

    public static void quit(){
        instance.quit();
        instance = null;
    }
}
