package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


@PageAccessor(pageName = "Wishlist")
public class WishlistPage extends CorePage {

    @FindBy(id = "mywishlist")
    private WebElement anchorElement;

    @FindBy(xpath = "//*[@id='block-history']/table/tbody")
    private WebElement wishlistTable;

    @FindBy(xpath = "//ul[contains(@class, 'row wlp_bought_list')]")
    private WebElement wishlistProductList;

    @FindBy(className = "wishlist_delete")
    private List<WebElement> deleteWishlistButtons;

    @ElementAccessor(elementName = "List field")
    @FindBy(id = "name")
    private WebElement inputListName;

    @ElementAccessor(elementName = "Save button")
    @FindBy(id = "submitWishlist")
    private WebElement submitNewWishlist;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public WebElement getWishlistTable() {
        return wishlistTable;
    }

    //TODO Can it be removed?
    public List<WebElement> getWishlists() {
        return wishlistTable.findElements(By.xpath("tr"));
    }

    public WebElement getWishlistFromTableByName(String wishlistName) {
        return getWishlistTable().findElement(By.xpath("..//td/a[contains(text(),'" + wishlistName + "')]"));
    }

    public List<WebElement> getDeleteWishlistButtons() {
        try {
            return getWishlistTable().findElements(By.className("icon-remove"));
        } catch (NoSuchElementException ex){
            return new ArrayList<>();
        }
    }

    public long getWishlistQty(String wishlistName) {
        return Long.valueOf(getWishlistFromTableByName(wishlistName).findElement(By.xpath("../../td[2]")).getText());
    }

    //TODO Can it be removed?
    public WebElement getInputListName(){
        return inputListName;
    }

    public WebElement getWishlistProductList(){
        return wishlistProductList;
    }

    public List<WebElement> getListOfProducts() {
        return wishlistProductList.findElements(By.tagName("li"));
    }

}