package com.automation_practice.actions;

import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.CheckoutPage;
import com.automation_practice.pages.OrdersPage;
import com.automation_practice.pages.PaymentPage;
import com.automation_practice.pages.SummaryPage;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.Arrays;
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
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE,summaryPage);
        String expectedProductName = summaryPage.getProductNameSummary().getText();
        Assert.assertEquals(productName,expectedProductName);
    }

    public void getReferenceCode(){
        PaymentPage paymentPage = (PaymentPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        String orderDetails  = paymentPage.getOrderDetails().getText();
        List<String> orderDetailsText = Arrays.asList(orderDetails.split("\\n"));
        String referenceNumber = orderDetailsText.get(4).replaceAll("[^A-Z]","").substring(1);
        scenarioContext.saveData(ScenarioKeys.REFERENCE_NUMBER,referenceNumber);
    }

    public void verifyAddedProduct(){
        OrdersPage ordersPage = (OrdersPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        String referenceNumber =  ordersPage.getFirstProduct().getText();
        Assert.assertEquals("Reference number is matched",referenceNumber,
                scenarioContext.getData(ScenarioKeys.REFERENCE_NUMBER));
    }
}