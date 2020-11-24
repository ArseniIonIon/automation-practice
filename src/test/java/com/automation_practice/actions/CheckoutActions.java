package com.automation_practice.actions;

import com.automation_practice.context.ProductType;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.AutomationPracticePage;
import com.automation_practice.pages.OrdersPage;
import com.automation_practice.pages.PaymentPage;
import com.automation_practice.pages.SummaryPage;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static com.automation_practice.context.ScenarioKeys.PRODUCT_TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutActions {

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();

    public void clickOnProductType(ProductType productType) {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData((ScenarioKeys.CURRENT_PAGE));
        List<WebElement> productTypes = automationPracticePage.getListOfProductTypes();
        for (WebElement element : productTypes) {
            if (element.getText().equalsIgnoreCase(productType.getDescription())) {
                CommonActions.moveToElement(element);
                element.click();
                break;
            }
        }
    }

    public void addProductToCart(String productName) {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        WebElement productElement = automationPracticePage.getProductByNameAndType(productName, (ProductType) scenarioContext.getData(PRODUCT_TYPE));
        CommonActions.scrollToElement(productElement);
        CommonActions.moveToElement(productElement);
        automationPracticePage.getAddToCartButton(productElement).click();
    }

    public void popUpDisplayed() {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        assertThat("Checkout Pop-up is displayed",automationPracticePage.getAddCartPopUp().isDisplayed(),is(true));

    }

    public void proceedToCheckout() {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        CommonActions.waitUntilElementDisplayed(automationPracticePage.getProceedToCheckOut());
        automationPracticePage.getProceedToCheckOut().click();
        }

    public void verifyProductInSummaryTab(String productName) {
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        String expectedProductName = summaryPage.getProductNameSummary().getText();
        assertThat(String.format("Expected product name: %s is displayed",productName),productName,equalTo(expectedProductName));
    }

    public void extractAndSaveReferenceCode() {
        PaymentPage paymentPage = (PaymentPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        assertThat("Order details are displayed", paymentPage.getOrderDetails().isDisplayed(), is(true));
        String orderDetails = paymentPage.getOrderDetails().getText();
        List<String> orderDetailsText = Arrays.asList(orderDetails.split("\\n"));
        String referenceNumber = orderDetailsText.get(4).replaceAll("[^A-Z]", "").substring(1);
        scenarioContext.saveData(ScenarioKeys.REFERENCE_NUMBER, referenceNumber);
    }

    public void verifyAddedProduct() {
        OrdersPage ordersPage = (OrdersPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        String referenceNumber = ordersPage.getFirstProduct().getText();
        assertThat("Reference number is matched", referenceNumber, equalTo(scenarioContext.getData(ScenarioKeys.REFERENCE_NUMBER)));
    }

    public void verifyEmptyCart(){
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        assertThat(summaryPage.getEmptyCartAlert().isDisplayed(), is(true));
    }
}