package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Payment")
public class PaymentPage extends CorePage {

    @FindBy(id = "cart_summary")
    protected WebElement anchorElement;

    @ElementAccessor(elementName = "Pay by bank wire button")
    @FindBy(css = "div#HOOK_PAYMENT div:nth-child(1) > div > p > a")
    protected WebElement bankPaymentType;

    @ElementAccessor(elementName = "Pay by check button")
    @FindBy(css = "div#HOOK_PAYMENT div:nth-child(2) > div > p > a")
    protected WebElement ticketPaymentType;

    @ElementAccessor(elementName = "I confirm my order button")
    @FindBy(css = "#cart_navigation > button")
    protected WebElement confirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    protected WebElement orderDetails;

    @ElementAccessor(elementName = "Back to orders button")
    @FindBy(css = "div#center_column p > a")
    protected WebElement backToOrdersBtn;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderDetails() {
        return orderDetails;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }
}
