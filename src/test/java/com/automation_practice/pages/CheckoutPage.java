package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAcccessot;
import com.automation_practice.annotations.PageAccessor;
import com.automation_practice.browsers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@PageAccessor(pageName = "Checkout")
public class CheckoutPage extends CorePage {
    @FindBy(id = "home-page-tabs")
    protected WebElement productCategory;

    @FindBy(id = "homefeatured")
    protected  WebElement productCategoryList;

    @ElementAcccessot(elementName = "Add to cart button")
    @FindBy(xpath = ".//a[@title='Add to cart']")
    protected WebElement addToCart;

    @FindBy(className = "clearfix")
    protected WebElement addCartPopUp;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    protected WebElement procedtoCheckOut;
    @FindBy(id = "cart_title")
    protected WebElement anchorElement;




    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public WebElement getProcedtoCheckOut() {
        return procedtoCheckOut;
    }

    public List<WebElement> getProductCategoryList() {
        return productCategoryList.findElements(By.tagName("li"));
    }

    public WebElement getAddCartPopUp() {
        return addCartPopUp;
    }


    public WebElement getAddToCart() {
        return addToCart;
    }

    public List<WebElement> getProductType() {
        return productCategory.findElements(By.tagName("li"));
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}
