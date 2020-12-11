package com.automation_practice.actions;

import com.automation_practice.context.ScenarioContext;
import com.automation_practice.pages.TShirtPage;
import com.automation_practice.pages.WishlistPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.context.ScenarioContext.getScenarioContext;
import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WishlistPageActions {

    private ScenarioContext scenarioContext = getScenarioContext();
    private WishlistPage wishlistPage = new WishlistPage(getInstance());

    public void addToWishlist(String productName){
        TShirtPage tShirtPage = new TShirtPage(getInstance());
        scenarioContext.saveData(CURRENT_PAGE,tShirtPage);
        tShirtPage.gettShirtOptionMenuBar().click();
        String pageTitle = tShirtPage.getPageTitle().toString().trim();
        Assert.assertEquals("T-shirts - My Store",pageTitle);
    }

    public void checktWishlistTable(){
        scenarioContext.saveData(CURRENT_PAGE,wishlistPage);
        WebElement defaultWishlistTable = wishlistPage.getWishlistTable();
        assertThat("Wishlist table is displayed",defaultWishlistTable.isDisplayed(),is(true));

    }

    public void openSpecificWishlist(String wishlistTitle){
        scenarioContext.saveData(CURRENT_PAGE,wishlistPage);
        wishlistPage.getWishlistFromTableByName(wishlistTitle).click();
    }

    public void validateWishlistProductQty(String wishlistName, long expectedQty){
        scenarioContext.saveData(CURRENT_PAGE,wishlistPage);
        assertThat(String.format("[%s] has expected quantity",wishlistName),
                wishlistPage.getWishlistQty(wishlistName),
                is(expectedQty));
    }

    public void openWishlistByName(String wislistTitle){
        scenarioContext.saveData(CURRENT_PAGE,wishlistPage);
        wishlistPage.getWishlistFromTableByName(wislistTitle).click();
    }

    public void getWishlistProductByTitle(String productTitle){
        scenarioContext.saveData(CURRENT_PAGE,wishlistPage);

//        List<WebElement> element = wishlistPage.getWishlistProductList();
        String targetElement = wishlistPage.getWishlistProductList().stream()
                .filter(element -> element.findElement(By.id("s_title"))
                        .getText().contains(productTitle)).findFirst()
                .orElseThrow(() -> new RuntimeException("No  such product:" + productTitle))
                        .findElement(By.id("s_title")).getText();

        assertThat("Wishlist have expected product",targetElement.toString().trim(),is(productTitle));

//        WebElement targetElement = wishlistPage.getWishlistProductList().stream()
//                .filter(element -> element.findElement(By.id("s_title")).getText().contains(productTitle))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Such product does not exists - " + productTitle));

//        assertThat("Wishlist have expected product",targetElement.toString().trim(),is(productTitle));


    }

}
