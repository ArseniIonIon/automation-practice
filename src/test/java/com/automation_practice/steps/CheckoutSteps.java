package com.automation_practice.steps;

import com.automation_practice.actions.CheckoutPageActions;
import com.automation_practice.utils.PageManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPageActions checkoutPage = new CheckoutPageActions();

   /* @Given("the {} page is displayed")
    public void isDisplayed(String pageName){
        Assert.assertTrue(String.format("Expected %S is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());
    }*/

    @When("the user goes to {} products")
    public void theUserGoesToPopularProducts(String category) {
        checkoutPage.clickOnProductType(category);
    }

    @And("add {string} product to cart")
    public void clicksOnProduct(String name) {
        checkoutPage.addProductToCart(name);
    }

    @Then("the product is successfully added to cart")
    public void popUpDisplayed() {
        checkoutPage.popUpDisplayed();
    }

    @When("user goes to checkout process")
    public void userGoesToCheckoutProcess() {
        checkoutPage.procedToCheckout();
        
    }

    @Then("the {string} steps are displayed")
    public void theCheckoutStepsAreDisplayed(String pageName) {
        Assert.assertTrue(String.format("Expected %S is displayed", pageName),
                PageManager.getPage(pageName).getAnchorElement().isDisplayed());

    }

    @And("the {string} is present on the card summary")
    public void theBlouseIsPresentOnTheCardSummary(String productName) {
        checkoutPage.verifyProductSummaryTab(productName);
    }



    @Then("the {string} tab is displayed")
    public void theAddressTabIsDisplayed(String orderStepName) {

    }


}
