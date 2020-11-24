package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Address")
public class AddressPage extends CorePage {
    @FindBy(id = "uniform-id_address_delivery")
    protected WebElement anchorElement;
    @ElementAccessor(elementName = "Checkout button")
    @FindBy(xpath = "//*[@type='submit' and @name='processAddress']")
    protected WebElement checkoutBtn;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }


}
