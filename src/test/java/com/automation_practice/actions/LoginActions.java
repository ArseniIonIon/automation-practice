package com.automation_practice.actions;


import com.automation_practice.context.ScenarioContext;
import com.automation_practice.pages.LoginPage;
import com.automation_practice.utils.PropertyParser;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation_practice.context.ScenarioContext.getScenarioContext;
import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginActions {

    private CommonActions commonActions = new CommonActions();

    private ScenarioContext scenarioContext = getScenarioContext();

    public void checkErrorMessage(String errorMessage){
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        List<WebElement> liElem = loginPage.getErrorMessages();
        for (WebElement element:liElem) {
            assertThat(String.format("Error message:  %s is displayed",errorMessage),errorMessage,equalTo(element.getText()));
        }
    }

    public void defaultUserLoginValues(){
        PropertyParser propertyParser = new PropertyParser();
        String login = propertyParser.getProps("login");
        String password = propertyParser.getProps("password");

        commonActions.typeOnField(login,"Email field");
        commonActions.typeOnField(password,"Password field");
    }
}
