package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageAccessor(pageName = "Product")
public class    ProductPage extends CorePage {

    @FindBy(className = "product_list row list")
    private WebElement productList;

    @FindBy(className = "product-container")
    private List<WebElement> listOfProducts;

    @ElementAccessor(elementName = "list button")
    @FindBy(id = "list")
    private WebElement displayProductsInList;

    @FindBy(className = "fancybox-error")
    private WebElement addToWishlistPopupText;

    @FindBy(xpath = "//a[contains(@class, 'fancybox-item fancybox-close')]")
    private WebElement closePopupButton;

    @ElementAccessor(elementName = "Continue Shopping button")
    @FindBy(xpath = "//span[contains(@title,'Continue shopping')]")
    private  WebElement continueShoppingButton;

    @ElementAccessor(elementName = "Add to cart button")
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement procedtoCheckOut;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToWishlistPopupText() {
        return addToWishlistPopupText;
    }

    public WebElement getProductByName(String productName){
       return listOfProducts.stream()
               .filter(element -> element.findElement(By.className("product-name")).getText().contains(productName))
               .findFirst()
               .orElseThrow(()->new RuntimeException("Such element does not exists - " + productName));
    }

    public WebElement getToProductWishlistButton(WebElement productElement){
        return productElement.findElement(By.xpath("..//a[contains(@class,'addToWishlist')]"));
    }

    public WebElement getToProductAddToCartButton(WebElement productElement){
        return productElement.findElement(By.xpath("..//a[contains(@title,'Add to cart')]"));
    }

    public WebElement getClosePopupButton() {
        return closePopupButton;
    }
}
