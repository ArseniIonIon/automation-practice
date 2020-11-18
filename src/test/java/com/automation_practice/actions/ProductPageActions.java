package com.automation_practice.actions;

import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class ProductPageActions {

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    public void addToWishlist(String productName){
        ProductPage productPage = (ProductPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);

//        List<WebElement> products = productPage.getProductList();
//        for (int i = 0; i <products.size(); i++) {
//            WebElement element = products.get(i);
//            if (element.findElement(By.className("product-name")).getText().contains(productName)){
//                CommonActions.moveToElement(element);
//                WebElement addToWishList = element.findElement(By.xpath("..//a[contains(@class,'addToWishlist')]"));
//                addToWishList.click();
//                break;
//            }
//        }

        WebElement productElement = productPage.getProductByName(productName);
        productPage.getToProductWishlistButton(productElement).click();
    }

    public void popupMessage(String popupText){
        ProductPage productPage = (ProductPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        Assert.assertEquals(popupText,productPage.getAddToWishlistPopupText().getText().trim());
    }

    public void closeWishlistPopup(){
        ProductPage productPage = (ProductPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        productPage.getClosePopupButton().click();

    }
}
