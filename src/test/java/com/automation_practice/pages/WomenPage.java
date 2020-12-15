package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Women")
public class WomenPage extends ProductPage {

    @FindBy(className = "category-name")
    private WebElement anchorElement;

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }
}
