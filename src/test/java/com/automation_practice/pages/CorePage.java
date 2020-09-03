package com.automation_practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class CorePage extends AbsPageFactory{

    @FindBy(className = "sf-with-ul")
    protected WebElement womenOptionMenuBar;

    public CorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWomenOptionMenuBar() {
        return womenOptionMenuBar;
    }
}
