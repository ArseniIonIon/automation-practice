package com.automation_practice.actions;

import com.automation_practice.browsers.Driver;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.pages.TShirtPage;
import com.automation_practice.pages.WishlistPage;
import com.automation_practice.utils.PageManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.context.ScenarioContext.getScenarioContext;
import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WishlistActions {

    private ScenarioContext scenarioContext = getScenarioContext();
    private CommonActions commonActions = new CommonActions();

    //TODO Can be removed?
    public void addToWishlist(String productName) {
        TShirtPage tShirtPage = new TShirtPage(getInstance());
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);
        tShirtPage.gettShirtOptionMenuBar().click();
        String pageTitle = tShirtPage.getPageTitle().toString().trim();
        //TODO assertThat
        Assert.assertEquals("T-shirts - My Store", pageTitle);
    }

    public void checktWishlistTable() {
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);
        WebElement defaultWishlistTable = wishlistPage.getWishlistTable();
        assertThat("Wishlist table is displayed", defaultWishlistTable.isDisplayed(), is(true));
    }

    public void wishlistTableDisplayedByName(String wishlistTableName){
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);
        WebElement wishlist = wishlistPage.getWishlistFromTableByName(wishlistTableName);
        commonActions.waitUntilElementDisplayed(wishlist);
        assertThat("Wishlist with " + wishlistTableName + " is displayed", wishlist.isDisplayed(), is(true));
    }

    public void deleteWishlists() {
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);

        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 5);

        List<WebElement> deleteWishlistButtonsAlt = wishlistPage.getDeleteWishlistButtons();
        while (deleteWishlistButtonsAlt.size() > 0) {
            deleteWishlistButtonsAlt.get(0).click();
            getInstance().switchTo().alert().accept();
            WishlistPage updatedWishlistPage = (WishlistPage) PageManager.getPage("Wishlist");
            List<WebElement> oldListOFButtons = deleteWishlistButtonsAlt;
            wait.until((ExpectedCondition<Boolean>) args -> oldListOFButtons.size()> updatedWishlistPage.getDeleteWishlistButtons().size());
            deleteWishlistButtonsAlt = wishlistPage.getDeleteWishlistButtons();
        }
        wishlistPage = (WishlistPage) PageManager.getPage("Wishlist");
        assertThat("Wishlist are deleted", wishlistPage.getDeleteWishlistButtons().size(), is(0));

    }

    public void openSpecificWishlist(String wishlistTitle) {
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);
        wishlistPage.getWishlistFromTableByName(wishlistTitle).click();
    }

    public void validateWishlistProductQty(String wishlistName, long expectedQty) {
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);
        assertThat(String.format("[%s] has expected quantity", wishlistName),
                wishlistPage.getWishlistQty(wishlistName),
                is(expectedQty));
    }

    public void openWishlistByName(String wislistTitle) {
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);

        commonActions.waitUntilElementDisplayed(wishlistPage.getWishlistTable());
        wishlistPage.getWishlistFromTableByName(wislistTitle).click();
    }

    public void getWishlistProductByTitle(String productTitle) {
        WishlistPage wishlistPage = (WishlistPage) scenarioContext.getData(CURRENT_PAGE);

        commonActions.waitUntilElementDisplayed(wishlistPage.getWishlistProductList());

        String targetElement = wishlistPage.getListOfProducts().stream()
                .filter(element -> element.findElement(By.id("s_title"))
                        .getText().contains(productTitle)).findFirst()
                .orElseThrow(() -> new RuntimeException("No  such product:" + productTitle))
                .findElement(By.id("s_title")).getText();

        assertThat("Wishlist have expected product", targetElement.toString().trim(), is(productTitle));
    }

}
