package com.automation_practice.hooks;

import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.AutomationPracticePage;
import com.automation_practice.utils.PageManager;
import com.automation_practice.utils.TakeScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

import java.io.IOException;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.browsers.Driver.quit;

public class Hooks {
    TakeScreenshot screenshot = new TakeScreenshot();
    ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();
    private Scenario scenario;


    @Before
    public void beforeAutomationPractice() throws IOException {
        PageManager.initPageClasses();
        getInstance().get("http://automationpractice.com/");
        screenshot.generateDirectory("feature");
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE,new AutomationPracticePage(getInstance()));
    }

    @AfterStep
    public void afterStepScreenshot(Scenario scenario){
        this.scenario = scenario;
        screenshot.makeAShot(scenario.getName());
    }

    @After
    public void afterAutomationPractice(){
        quit();
    }

}
