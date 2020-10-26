package com.automation_practice.steps;

import com.automation_practice.actions.CommonActions;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.utils.PageManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CommonSteps {

    ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    @When("user clicks on {} button")
    public void userClickOnButton(String name) throws IllegalAccessException {
        WebElement element = PageManager.getPageElementByName(name);
        CommonActions.scrollToElement(element);
        element.click();
    }

    @Then("the {string} page is displayed")
    public void pageDisplayed(String pageName) {
        Assert.assertTrue(String.format("Expected %s page is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE,PageManager.getPage(pageName));
    }
}
