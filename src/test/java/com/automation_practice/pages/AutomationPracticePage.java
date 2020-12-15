package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import com.automation_practice.context.ProductType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageAccessor(pageName = "AutomationPractice")
public class AutomationPracticePage extends CorePage {

    @FindBy(id = "homeslider")
    private WebElement anchorElement;

    @FindBy(id = "homefeatured")
    private WebElement productCategoryPopularList;

    @FindBy(id = "blockbestsellers")
    private WebElement productCategoryBestSellerList;

    @FindBy(id = "home-page-tabs")
    private WebElement productCategory;

    @FindBy(className = "clearfix")
    private WebElement addCartPopUp;

    @ElementAccessor(elementName = "Add to cart button")
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement procedtoCheckOut;


    public AutomationPracticePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getAnchorElement() {
        return anchorElement;
    }

    public List<WebElement> getListOfProductTypes() {
        return productCategory.findElements(By.tagName("li"));
    }

    public List<WebElement> getProductCategoryList(ProductType productType) {
        if (productType.equals(ProductType.POPULAR)) {
            return productCategoryPopularList.findElements(By.tagName("li"));
        }
        return productCategoryBestSellerList.findElements(By.tagName("li"));
    }

    public WebElement getProceedToCheckOut() {
        return procedtoCheckOut;
    }

    public WebElement getProductByNameAndType(String productName, ProductType productType) {
        return getProductCategoryList(productType).stream()
                .filter(element -> element.findElement(By.className("product-name")).getText().contains(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Such element does not exists - " + productName));
    }

    public WebElement getAddToCartButton(WebElement productElement) {
        return productElement.findElement(By.xpath(".//a[@title='Add to cart']"));
    }

    public WebElement getAddCartPopUp() {
        return addCartPopUp;
    }

}
