package com.automation_practice.steps;

import com.automation_practice.actions.CheckoutPageActions;
import com.automation_practice.utils.PageManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutSteps {
    private final Logger logger = (Logger) LoggerFactory.getLogger(CheckoutSteps.class);

    private CheckoutPageActions checkoutPage = new CheckoutPageActions();

   /* @Given("the {} page is displayed")
    public void isDisplayed(String pageName){
        Assert.assertTrue(String.format("Expected %S is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());
    }*/

    @When("the user goes to {} products")
    public void theUserGoesToPopularProducts(String category) {
        checkoutPage.clickOnProductType(category);
        logger.info("The user goes to " + category + " products");
    }

    @And("add {string} product to cart")
    public void clicksOnProduct(String name) {
        checkoutPage.addProductToCart(name);
        logger.info("add "+ name + " product to cart");
    }

    @Then("the product is successfully added to cart")
    public void popUpDisplayed() {
        checkoutPage.popUpDisplayed();
        logger.info("The product is successfully added to cart");
    }

    @When("user goes to checkout process")
    public void userGoesToCheckoutProcess() {
        checkoutPage.procedToCheckout();
        logger.info("User goes to checkout process");
    }

    @Then("the {string} steps are displayed")
    public void theCheckoutStepsAreDisplayed(String pageName) {
        Assert.assertTrue(String.format("Expected %S is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());
        logger.info("The " + pageName + " steps are displayed");
    }

    @And("the {string} is present on the card summary")
    public void theBlouseIsPresentOnTheCardSummary(String productName) {
        checkoutPage.verifyProductSummaryTab(productName);
        logger.info("The " + productName + " is present on the card summary");
    }

    @Then("the {string} tab is displayed")
    public void theAddressTabIsDisplayed(String orderStepName) {
    }
}
