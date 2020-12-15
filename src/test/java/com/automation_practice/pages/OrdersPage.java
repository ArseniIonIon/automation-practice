package com.automation_practice.pages;

import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "Orders")
public class OrdersPage extends CorePage {
    @FindBy(id = "order-list")
    private WebElement anchorElement;
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
    private WebElement firstProduct;

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstProduct() {
        return firstProduct;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

}
