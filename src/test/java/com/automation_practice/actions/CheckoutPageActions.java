package com.automation_practice.actions;

import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.CheckoutPage;
import com.automation_practice.pages.SummaryPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation_practice.browsers.Driver.getInstance;

public class CheckoutPageActions {

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    public void clickOnProductType(String productType){
        CheckoutPage checkoutPage = new CheckoutPage(getInstance());
        List<WebElement> productList = checkoutPage.getProductType();

        for (WebElement element: productList) {
            if (element.getText().equalsIgnoreCase(productType)){
                CommonActions.moveToElement(element);
                element.click();
                break;
            }
        }
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE, checkoutPage);

    }

    public void addProductToCart(String productName){
        CheckoutPage checkoutPage = (CheckoutPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        List<WebElement> categoryProducts = checkoutPage.getProductCategoryList();

        for (int i = 0; i <categoryProducts.size(); i++) {
            WebElement element = categoryProducts.get(i);
            if (element.findElement(By.className("product-name")).getText().contains(productName)){
                CommonActions.moveToElement(element);
                WebElement addToCart = element.findElement(By.xpath(".//a[@title='Add to cart']"));
                addToCart.click();
                break;
            }
        }

    }

    public void popUpDisplayed(){
        CheckoutPage checkoutPage = (CheckoutPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        //CommonActions.waitVisible(checkoutPage.getAddToCart(),3);
        CommonActions.wait(5);
        Assert.assertTrue(checkoutPage.getAddCartPopUp().isDisplayed());
    }

    public void procedToCheckout(){
        CheckoutPage checkoutPage = (CheckoutPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        CommonActions.waitVisible(checkoutPage.getProcedtoCheckOut(),5);
        checkoutPage.getProcedtoCheckOut().click();
        CommonActions.wait(4);
    }

    public void verifyProductSummaryTab(String productName){
        SummaryPage summaryPage = new SummaryPage(getInstance());
        String expectedProductName = summaryPage.getProductNameSummary().getText();
        Assert.assertEquals(productName,expectedProductName);
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE,summaryPage);
    }

    public void clickCheckOutBtn(){
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        CommonActions.scrollToElement(summaryPage.getCheckoutBtn());
        summaryPage.getCheckoutBtn().click();
    }

}