package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Payment")
public class PaymentPage extends CorePage {

    @FindBy(id = "cart_summary")
    private WebElement anchorElement;

    @FindBy(className = "bankwire")
    private WebElement bankPaymentType;

    @FindBy(className = "cheque")
    private WebElement ticketPaymentType;

    @ElementAccessor(elementName = "I confirm my order button")
    @FindBy(css = "#cart_navigation > button")
    protected WebElement confirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    private WebElement orderDetails;

    @ElementAccessor(elementName = "Back to orders button")
    @FindBy(css = "div#center_column p > a")
    private WebElement backToOrdersBtn;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderDetails() {
        return orderDetails;
    }

    public WebElement getBankPaymentType() {
        return bankPaymentType;
    }

    public WebElement getTicketPaymentType() {
        return ticketPaymentType;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }
}
