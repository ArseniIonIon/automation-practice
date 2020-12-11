package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "T-Shirt")
public class TShirtPage extends ProductPage {

    @FindBy(xpath = "//span[@class='category-name' and contains(text(),'T-shirts')]")
    private WebElement anchorElement;

    public TShirtPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }
}
