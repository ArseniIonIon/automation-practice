package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Summary")
public class SummaryPage extends CorePage {

    @ElementAccessor(elementName = "Delete button")
    @FindBy(xpath =  "//*[@id=\"cart_summary\"]/tbody/tr[1]/td[7]" )
    protected WebElement deleteBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    protected WebElement emptyCartAlert;

    @ElementAccessor(elementName = "Checkout button")
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    protected WebElement checkoutBtn;

    @FindBy(xpath = "//*[@id=\"cart_summary\"]/tbody/tr[1]/td[2]/p")
    protected WebElement productNameSummary;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    protected WebElement anchorElement;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductNameSummary() {
        return productNameSummary;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public WebElement getEmptyCartAlert() {
        return emptyCartAlert;
    }
}
