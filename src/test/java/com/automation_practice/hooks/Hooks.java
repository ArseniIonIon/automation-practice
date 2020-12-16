package com.automation_practice.hooks;

import com.automation_practice.actions.CheckoutActions;
import com.automation_practice.actions.WishlistActions;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.AutomationPracticePage;
import com.automation_practice.steps.CommonSteps;
import com.automation_practice.utils.PageManager;
import com.automation_practice.utils.ScreenshotMaker;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

import java.io.IOException;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.browsers.Driver.quit;

public class Hooks {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    private CommonSteps commonSteps = new CommonSteps();

    private CheckoutActions checkoutActions = new CheckoutActions();

    private WishlistActions wishlistActions = new WishlistActions();

    @Before
    public void beforeAutomationPractice() throws IOException {
        PageManager.initPageClasses();
        getInstance().get("http://automationpractice.com/");
        screenshotMaker.generateDirectory("feature");
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE,new AutomationPracticePage(getInstance()));
    }

    @AfterStep
    public void afterStepScreenshot(Scenario scenario){
        screenshotMaker.makeAShot(scenario.getName());
    }

    @After(value = "@cleanCart", order = 2)
    public void deleteProductFromCart() {
        commonSteps.userDeletesAllProductsFromCart();
        checkoutActions.verifyEmptyCart();
    }

    @After(value = "@ClearWishlist")
    public void removeDefaultWishlist(){
        wishlistActions.deleteWishlists();
    }

    @After(order = 1)
    public void afterAutomationPractice() {
        quit();
    }
}
