package com.automation_practice.hooks;

import com.automation_practice.utils.PageManager;
import com.automation_practice.utils.TakeScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import gherkin.ast.Feature;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.browsers.Driver.quit;

public class Hooks {
    TakeScreenshot screenshot = new TakeScreenshot();

    @Before
    public void initPage(){
        PageManager.initPageClasses();
    }
    @Before
    public void beforeAutomationPractice(){

        getInstance().get("http://automationpractice.com/");
        screenshot.generateDirectory();
    }

    @AfterStep
    public void afterStepScreenshot(){
        screenshot.makeAShot();
    }

    @After
    public void afterAutomationPractice(){
        quit();
    }

}
