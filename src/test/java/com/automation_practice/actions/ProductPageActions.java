package com.automation_practice.actions;

import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.ProductPage;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductPageActions {

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    private CommonActions commonActions = new CommonActions();

    //TODO all these methods can be moved to WishlistActions

    public void addToWishlist(String productName){
        ProductPage productPage = (ProductPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);

        WebElement productElement = productPage.getProductByName(productName);
        productPage.getToProductWishlistButton(productElement).click();
    }

    public void popupMessage(String popupText){
        ProductPage productPage = (ProductPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        commonActions.waitUntilElementDisplayed(productPage.getAddToWishlistPopupText());
        assertThat("Popup is displayed", productPage.getAddToWishlistPopupText().getText(), is(popupText));
    }

    public void closeWishlistPopup(){
        ProductPage productPage = (ProductPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        commonActions.moveToElement(productPage.getClosePopupButton());
        productPage.getClosePopupButton().click();
    }
}
