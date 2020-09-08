package com.automation_practice.actions;



import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys.*;
import com.automation_practice.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.context.ScenarioContext.getScenarioContext;
import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;

public class LoginPageActions {

    private ScenarioContext scenarioContext = getScenarioContext();

    public void openSignInPage() {
        LoginPage loginPage = new LoginPage(getInstance());
        loginPage.getSignInBtn().click();
        Actions.wait(10);
        scenarioContext.saveData(CURRENT_PAGE, loginPage);
    }

    public void verifyEmptyEmailField() {
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        WebElement emailField = loginPage.getEmailField();
        Assert.assertTrue(emailField.isDisplayed() && emailField.getText().isEmpty());
    }

    public void verifyEmptyPasswordField() {
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        WebElement pswField = loginPage.getEmailField();
        Assert.assertTrue(pswField.isDisplayed() && pswField.getText().isEmpty());
    }

    public void clickOnSignInBtn(){
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        loginPage.getSubmitBtn().click();
        Actions.wait(5);
    }

    public void checkErrorMessage(String errorMessage){
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        List<WebElement> liElem = loginPage.getErrorMessages();
        for (WebElement element:liElem) {
            Assert.assertEquals(element.getText(), errorMessage);
            System.out.println(element.getText());
        }
    }

    public void typeEmail(String email){
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        loginPage.getEmailField().sendKeys(email);
    }

    public void typePassword(String psw){
        LoginPage loginPage = (LoginPage) scenarioContext.getData(CURRENT_PAGE);
        loginPage.getPasswordField().sendKeys(psw);
    }


}
