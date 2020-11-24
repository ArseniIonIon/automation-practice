package com.automation_practice.steps;

import com.automation_practice.actions.CheckoutActions;
import com.automation_practice.context.ProductType;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.ProductPage;
import com.automation_practice.utils.PageManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CheckoutSteps {
    private final Logger logger = LoggerFactory.getLogger(CheckoutSteps.class);

   private CheckoutActions checkoutActions = new CheckoutActions();
   private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();


    @When("the user goes to {} products")
    public void theUserGoesToProductType(ProductType productType) {
        checkoutActions.clickOnProductType(productType);
        logger.info("The user goes to " + productType + " products");
        scenarioContext.saveData(ScenarioKeys.PRODUCT_TYPE,productType);
    }

    @Then("add {string} product to cart")
    public void clicksOnProduct(String name) {
        checkoutActions.addProductToCart(name);
        logger.info("add "+ name + " product to cart");
    }

    @Then("the product is successfully added to cart")
    public void popUpDisplayed() {
        checkoutActions.popUpDisplayed();
        logger.info("The product is successfully added to cart");
    }

    @When("user goes to checkout process")
    public void userGoesToCheckoutProcess() {
        checkoutActions.proceedToCheckout();
        logger.info("User goes to checkout process");
    }

    @Then("the {string} steps are displayed")
    public void theCheckoutStepsAreDisplayed(String pageName) {
        Assert.assertTrue(String.format("Expected %S is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());
        logger.info("The " + pageName + " steps are displayed");
    }

    @Then("the {string} is present on the card summary")
    public void theProductIsPresentOnTheCardSummary(String productName) {
        checkoutActions.verifyProductInSummaryTab(productName);
        logger.info("The " + productName + " is present on the card summary");
    }

    @Then("order details are displayed")
    public void orderDetailsAreDisplayed() {
        checkoutActions.extractAndSaveReferenceCode();

    }

    @Then("the order is present in the list")
    public void theProductIsPresentInTheList() {
        checkoutActions.verifyAddedProduct();
    }

}
