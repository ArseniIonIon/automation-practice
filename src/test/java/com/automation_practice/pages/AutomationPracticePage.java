package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "homePage")

public class AutomationPracticePage extends CorePage {

    public AutomationPracticePage(WebDriver driver){
        super(driver);
    }

}
