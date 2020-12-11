package com.automation_practice.steps;

import com.automation_practice.actions.CommonActions;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static com.automation_practice.utils.PageManager.getPage;
import static com.automation_practice.utils.PageManager.getPageElementByName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;

public class CommonSteps {

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    private CommonActions commonActions = new CommonActions();

    @When("user clicks on {}")
    public void userClickOnButton(String name) {
        WebElement element = getPageElementByName(name);
        commonActions.scrollToElement(element);
        element.click();
    }

    @Then("the {string} page is displayed")
    public void pageDisplayed(String pageName) {
        commonActions.scrollToElement(getPage(pageName).getAnchorElement());
        assertThat(String.format("Expected %s page is displayed", pageName),
                getPage(pageName).getAnchorElement().isDisplayed(), is(true));
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE, getPage(pageName));
    }

    @Then("the {string} is empty")
    public void theFieldIsEmpty(String fieldName) {
        String textFromField = commonActions.getTextFromField(fieldName);
        assertThat(String.format("The field: %s is empty", fieldName), textFromField, isEmptyString());
    }

    @When("user types {string} in {string}")
    public void userTypesInField(String text, String fieldName) {
        commonActions.typeOnField(text, fieldName);
    }

}
