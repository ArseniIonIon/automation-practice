package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageAccessor(pageName = "MyAccount")
public class MyAccountPage extends CorePage {

    @FindBy(id = "my-account")
    private WebElement anchorElement;

    @ElementAccessor(elementName = "My Wishlist button")
    @FindBy(className = "lnk_wishlist")
    private WebElement wishlistButton;


    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWishlistButton() {
        return wishlistButton;
    }
}






