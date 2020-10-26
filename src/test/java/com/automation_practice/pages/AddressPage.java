package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Address")
public class AddressPage extends CorePage {
    public AddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "uniform-id_address_delivery")
    protected WebElement anchorElement;

    @ElementAccessor(elementName = "Checkout")
    @FindBy(xpath = "//*[@type='submit' and @name='processAddress']")
    protected WebElement checkoutBtn;

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }


}
