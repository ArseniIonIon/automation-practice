package com.automation_practice.actions;


import com.automation_practice.context.ScenarioContext;
import com.automation_practice.pages.LoginPage;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation_practice.context.ScenarioContext.getScenarioContext;
import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginActions {

    private ScenarioContext scenarioContext = getScenarioContext();

    public void checkErrorMessage(String errorMessage){
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        List<WebElement> liElem = loginPage.getErrorMessages();
        for (WebElement element:liElem) {
            assertThat(String.format("Error message:  %s is displayed",errorMessage),errorMessage,equalTo(element.getText()));
        }
    }
}
