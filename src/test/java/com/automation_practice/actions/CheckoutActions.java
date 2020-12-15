package com.automation_practice.actions;

import com.automation_practice.context.PaymentType;
import com.automation_practice.context.ProductType;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.*;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;
import static com.automation_practice.context.ScenarioKeys.PRODUCT_TYPE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckoutActions {

    private ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();
    private CommonActions commonActions = new CommonActions();

    public void clickOnProductType(ProductType productType) {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData((ScenarioKeys.CURRENT_PAGE));
        List<WebElement> productTypes = automationPracticePage.getListOfProductTypes();
        for (WebElement element : productTypes) {
            if (element.getText().equalsIgnoreCase(productType.getDescription())) {
                commonActions.moveToElement(element);
                element.click();
                break;
            }
        }
    }

    public void addProductToCart(String productName) {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        WebElement productElement = automationPracticePage.getProductByNameAndType(productName, (ProductType) scenarioContext.getData(PRODUCT_TYPE));
        commonActions.scrollToElement(productElement);
        commonActions.moveToElement(productElement);
        automationPracticePage.getAddToCartButton(productElement).click();
    }

    public void popUpDisplayed() {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        assertThat("Checkout Pop-up is displayed", automationPracticePage.getAddCartPopUp().isDisplayed(), is(true));
    }

    public void proceedToCheckout() {
        AutomationPracticePage automationPracticePage = (AutomationPracticePage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        commonActions.waitUntilElementDisplayed(automationPracticePage.getProceedToCheckOut());
        automationPracticePage.getProceedToCheckOut().click();
    }

    public void verifyProductInSummaryTab(String productName) {
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        String expectedProductName = summaryPage.getProductNameSummary().getText();
        assertThat(String.format("Expected product name: %s is displayed", productName), productName, equalTo(expectedProductName));
    }

    public void selectPaymentType(PaymentType paymentType) {
        PaymentPage paymentPage = (PaymentPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        if (paymentType.equals(PaymentType.PAY_BY_BANK)) {
            paymentPage.getBankPaymentType().click();
        } else {
            paymentPage.getTicketPaymentType().click();
        }
    }

    public void extractAndSaveReferenceCode() {
        PaymentPage paymentPage = (PaymentPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        assertThat("Order details are displayed", paymentPage.getOrderDetails().isDisplayed(), is(true));
        String orderDetails = paymentPage.getOrderDetails().getText();
        List<String> orderDetailsText = Arrays.asList(orderDetails.split("\\n"));

        PaymentType paymentType = (PaymentType) scenarioContext.getData(ScenarioKeys.PAYMENT_TYPE);
        String referenceNumber = orderDetailsText
                .get(paymentType.getReferenceNumberIndex())
                .replaceAll("[^A-Z]", "").substring(1);
        assertThat("Reference number is not empty", referenceNumber, not(isEmptyString()));
        scenarioContext.saveData(ScenarioKeys.REFERENCE_NUMBER, referenceNumber);

    }

    public void verifyAddedProduct() {
        OrdersPage ordersPage = (OrdersPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        String referenceNumber = ordersPage.getFirstProduct().getText();
        assertThat("Reference number is matched", referenceNumber, equalTo(scenarioContext.getData(ScenarioKeys.REFERENCE_NUMBER)));
    }

    public void verifyEmptyCart() {
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        commonActions.waitUntilElementDisplayed(summaryPage.getEmptyCartAlert());
        assertThat(summaryPage.getEmptyCartAlert().isDisplayed(), is(true));
    }

    public void verifyTotalPriceForProducts(double price){
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);
        commonActions.waitUntilElementDisplayed(summaryPage.getTotalPriceForProducts());
        String stringPrice = summaryPage.getTotalPriceForProducts().getText().replace("$","");
        Double doublePrice = Double.parseDouble(stringPrice);
        assertThat("The price is right", price,is(doublePrice));
    }

    public void productIsPresentInCart(String productTitle) {
        SummaryPage summaryPage = (SummaryPage) scenarioContext.getData(CURRENT_PAGE);

        commonActions.waitUntilElementDisplayed(summaryPage.getListOfProducts());

        assertThat("The product is displayed in cart",summaryPage.getProductByName(productTitle).isDisplayed(),is(true));

    }
}