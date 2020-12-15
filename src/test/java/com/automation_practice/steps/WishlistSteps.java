package com.automation_practice.steps;

import com.automation_practice.actions.WishlistActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WishlistSteps {

    private final Logger logger = (Logger) LoggerFactory.getLogger(CheckoutSteps.class);

    private WishlistActions wishlistActions = new WishlistActions();


    @When("user adds {} product to Wishlist")
    public void addToWishListAProductByTitle(String productName){
        wishlistActions.addToWishlist(productName);
        logger.info("User adds '" + productName + "' product to Wishlist");
    }

    @Then("new wishlist with title {} is displayed")
    public void wishlistTableDisplayedByName(String wishlistTableName){
        wishlistActions.wishlistTableDisplayedByName(wishlistTableName);
        logger.info(wishlistTableName + " - wishlist is created");
    }

    @Then("popup with {} message is displayed")
    public void addedToWishlistPopupDisplayed(String addToWishlistPopupMessage){
        wishlistActions.popupMessage(addToWishlistPopupMessage);
    }

    @When("user closes the popup")
    public void closeWishlistPopup(){
        wishlistActions.closeWishlistPopup();
        logger.info("Wishlist popup closed");
    }

    @Then("the default Wishlist table is displayed")
    public void defaultWishlistTableDisplayed(){
        wishlistActions.checktWishlistTable();
        logger.info("Default Wishlist Table is displayed");
    }

    @Then("the {string} has {} product")
    public void productAddedInWishlist(String wishlistName, long expectedQty){
        wishlistActions.validateWishlistProductQty(wishlistName,expectedQty);
        logger.info("{} - has {} products",wishlistName,expectedQty);
    }

    @When("the user open {} list")
    public void openSpecificWishlist(String wishlistTitle){
        wishlistActions.openWishlistByName(wishlistTitle);
        logger.info(String.format("%s is clicked",wishlistTitle));
    }

    @Then("the {} is present into the list")
    public void productIsPresentInWishlist(String productTitle){
        wishlistActions.getWishlistProductByTitle(productTitle);
    }
}
