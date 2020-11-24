package com.automation_practice.steps;

import com.automation_practice.actions.LoginActions;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    private LoginActions loginActions = new LoginActions();

    @Then("the error message: {string} is displayed")
    public void errorMessageDisplayed(String errorMsg) {
        loginActions.checkErrorMessage(errorMsg);
        logger.info("Error message is displayed:\n\" " + errorMsg + " \"");
    }
}
