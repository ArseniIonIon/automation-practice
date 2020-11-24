package com.automation_practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends CorePage {

    @FindBy(xpath = "//*[@id='block-history']/table/tbody")
    private WebElement wishlistTable;

    @FindBy(xpath = "//ul[contains(@class, 'row wlp_bought_list')]")
    private WebElement wishlistProductList;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWishlistTable() {
        return wishlistTable;
    }

    public List<WebElement> getWishlists() {
        return wishlistTable.findElements(By.xpath("tr"));
    }

    public WebElement getWishlistFromTableByName(String wishlistName) {
        return getWishlistTable().findElement(By.xpath("..//td/a[contains(text(),'" + wishlistName + "')]"));
    }

    public long getWishlistQty(String wishlistName) {
        return Long.valueOf(getWishlistFromTableByName(wishlistName).findElement(By.xpath("../../td[2]")).getText());
    }

    public List<WebElement> getWishlistProductList() {
        return wishlistProductList.findElements(By.tagName("li"));
    }


//    public WebElement getWishlistProductByTitle(String productTitle){
//        return getWishlistProductList().stream()
//                .filter(element -> element.findElement(By.id("s_title")).getText().contains(productTitle))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Such product does not exists - " + productTitle));
//
//    }

}
