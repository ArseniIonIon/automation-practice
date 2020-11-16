package com.automation_practice.steps;

import com.automation_practice.actions.CommonActions;
import com.automation_practice.actions.LoginPageActions;
import com.automation_practice.browsers.Driver;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.LoginPage;
import com.automation_practice.utils.PageManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private LoginPageActions loginPage = new LoginPageActions();
    ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    @Given("the User clicks on {}")
    public void clickOnButton(String name) throws IllegalAccessException, InterruptedException {
        loginPage.openSignInPage(name);
        Thread.sleep(10);
    }

    @And("the field email is empty")
    public void theField() {
        loginPage.verifyEmptyEmailField();
    }

    @And("the field password is empty")
    public void theFieldIsEmpty() {
        loginPage.verifyEmptyPasswordField();
    }

    /*@When("user clicks on {string} button")
    public void clickOnEnter(String btnName) {
        loginPage.clickOnSignInBtn(btnName);
    }*/

    @Then("the error message: {string} is displayed")
    public void errorMessageDisplayed(String errorMsg) {
        loginPage.checkErrorMessage(errorMsg);
    }

    @When("user types {string} in email field")
    public void userTypesInEmailField(String email) {
        loginPage.typeEmail(email);
    }

    @And("types {string} in password field")
    public void typesInPasswordField(String psw) {
        loginPage.typePassword(psw);
    }

    @And("the user is on {} page")
    public void myAccountPageIsDisplayed (String pageName) {
        Assert.assertTrue(String.format("Expected %s page is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());
    }
}
