package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@PageAccessor(pageName = "Login")
public class LoginPage extends CorePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(css = "#center_column > div.alert.alert-danger")
    private WebElement errorMessage;

    @ElementAccessor(elementName = "Sign In button")
    @FindBy(id = "SubmitLogin")
    private WebElement submitBtn;

    @FindBy(id = "email")
    private WebElement anchorElement;


    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public List<WebElement> getErrorMessages() {
        return errorMessage.findElements(By.tagName("li"));
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
