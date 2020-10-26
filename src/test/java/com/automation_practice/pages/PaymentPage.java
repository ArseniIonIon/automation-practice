package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageAccessor(pageName = "Payment")
public class PaymentPage extends CorePage {

    @FindBy(id = "HOOK_TOP_PAYMENT")
    protected WebElement anchorElement;

    @FindBy(className = "payment_module")
    protected List<WebElement> paymentTypes;

    public List<WebElement> getPaymentType() {
        return paymentTypes;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
}
