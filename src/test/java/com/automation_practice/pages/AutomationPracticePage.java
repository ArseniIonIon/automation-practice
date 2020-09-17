package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "AutomationPractice")
public class  AutomationPracticePage extends CorePage {

    @FindBy(id = "homeslider")
    protected WebElement anchorElement;

    public AutomationPracticePage(WebDriver driver){
        super(driver);
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }
}
