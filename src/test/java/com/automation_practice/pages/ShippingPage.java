package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@PageAccessor(pageName = "Shipping")
public class ShippingPage extends CorePage {

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[2]")
    protected WebElement anchorElement;

    @ElementAccessor(elementName = "Terms of service")
    @FindBy(id = "cgv")
    protected WebElement checkboxTerms;

    @ElementAccessor(elementName = "Checkout")
    @FindBy(css = "form#form button[type=\"submit\"] > span")
    protected WebElement checkoutBtn;

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }

    public WebElement getCheckboxTerms() {
        return checkboxTerms;
    }
    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public ShippingPage(WebDriver driver) {
        super(driver);
    }


}
