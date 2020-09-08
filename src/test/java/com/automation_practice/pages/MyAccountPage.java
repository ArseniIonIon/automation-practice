package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "MyAccount")
public class MyAccountPage extends CorePage {

    @FindBy(id = "my-account")
    private WebElement anchorElement;


    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
}
