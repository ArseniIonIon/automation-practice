package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.security.krb5.internal.PAData;

@PageAccessor(pageName = "Orders")
public class OrdersPage extends CorePage{
    @FindBy(id = "order-list")
    protected WebElement anchorElement;
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
    protected WebElement firstProduct;

    public WebElement getFirstProduct() {
        return firstProduct;
    }
    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }
    public OrdersPage(WebDriver driver) {
        super(driver);
    }

}
