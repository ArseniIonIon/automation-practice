package com.automation_practice.hooks;

import com.automation_practice.utils.PageManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.browsers.Driver.quit;

public class Hooks {

    @Before
    public void initPages(){
        PageManager.initPageClasses();
    }

    @Before
    public void beforeAutomationPractice(){
        getInstance().get("http://automationpractice.com/");
    }

   /* @After
    public void afterAutomationPractice(){
        quit();
    }*/

}
