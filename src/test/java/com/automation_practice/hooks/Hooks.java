package com.automation_practice.hooks;

import org.junit.After;
import org.junit.Before;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.browsers.Driver.quit;

public class Hooks {

    @Before
    private void beforeAutomationPractice(){
        getInstance().get("http://automationpractice.com/");
    }

    @After
    private void afterAutomationPractice(){
        quit();
    }

}
