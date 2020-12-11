package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageAccessor(pageName = "Product")
public class ProductPage extends CorePage {

    @FindBy(xpath = "//ul[contains(@class,'product_list')]")
    private WebElement productList;

    @ElementAccessor(elementName = "list button")
    @FindBy(id = "list")
    private WebElement displayProductsInList;

    @FindBy(xpath = "//div[@class='fancybox-outer']/div/p")
    private WebElement addToWishlistPopupText;

    @FindBy(xpath = "//div[@class='fancybox-skin']/a")
    private WebElement closePopupButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductList() {
        return productList.findElements(By.tagName("li"));
    }

    public WebElement getDisplayProductsInList(){
        return displayProductsInList;
    }

    public WebElement getAddToWishlistPopupText() {
        return addToWishlistPopupText;
    }

    public WebElement getProductByName(String productName){

       return getProductList().stream()
               .filter(element -> element.findElement(By.className("product-name")).getText().contains(productName))
               .findFirst()
               .orElseThrow(()->new RuntimeException("Such element does not exists - " + productName));
    }

    public WebElement getToProductWishlistButton(WebElement productElement){
        return productElement.findElement(By.xpath("..//a[contains(@class,'addToWishlist')]"));
    }

    public WebElement getClosePopupButton() {
        return closePopupButton;
    }
}
