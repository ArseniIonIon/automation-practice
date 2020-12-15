package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageAccessor(pageName = "Summary")
public class SummaryPage extends CorePage {

    @ElementAccessor(elementName = "Delete button")
    @FindBy(xpath =  "//*[@id=\"cart_summary\"]/tbody/tr[1]/td[7]" )
    private WebElement deleteBtn;

    @ElementAccessor(elementName = "Delete button list")
    @FindBy(className = "icon-trash")
    private List<WebElement> deleteButtonsList;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement emptyCartAlert;

    @ElementAccessor(elementName = "Checkout button")
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//*[@id=\"cart_summary\"]/tbody/tr[1]/td[2]/p")
    private WebElement productNameSummary;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    private WebElement anchorElement;

    @FindBy(id = "total_product")
    private WebElement totalPriceForProducts;

    @FindBy(tagName = "tbody")
    private WebElement listOfProducts;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getListOfProductsWebElements() {
        return listOfProducts.findElements(By.tagName("tr"));
    }

    public WebElement getProductByName(String productName){
        return getListOfProductsWebElements().stream()
                .filter(element -> element.findElement(By.className("product-name")).getText().contains(productName))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Such element does not exists - " + productName));
    }

    public WebElement getTotalPriceForProducts() {
        return totalPriceForProducts;
    }

    public WebElement getProductNameSummary() {
        return productNameSummary;
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public WebElement getEmptyCartAlert() {
        return emptyCartAlert;
    }

    public WebElement getListOfProducts() {
        return listOfProducts;
    }

    public List<WebElement> getDeleteButtonsList() {
        return deleteButtonsList;
    }
}
