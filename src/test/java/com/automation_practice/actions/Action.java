package com.automation_practice.actions;

import com.automation_practice.browsers.Driver;

import java.util.concurrent.TimeUnit;

public class Action {

    //public static WebDriver driver = Driver.getInstance();

    public static void wait(int seconds){
        Driver.getInstance().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}
