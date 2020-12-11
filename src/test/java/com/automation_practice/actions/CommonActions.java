package com.automation_practice.actions;

import com.automation_practice.utils.PageManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automation_practice.browsers.Driver.getInstance;

public class CommonActions {

    private final static int TIMEOUT = 10;

    public void moveToElement(WebElement element) {
        Actions action = new Actions(getInstance());
        action.moveToElement(element);
        action.perform();
    }

    public void waitUntilElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getInstance(), TIMEOUT);
        wait.until((ExpectedCondition<Boolean>) arg -> element.isDisplayed());
    }

    public void scrollToElement(WebElement element) {
        WebDriver driver = getInstance();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getTextFromField(String fieldName) {
        WebElement element = PageManager.getPageElementByName(fieldName);
        return element.getText();
    }

    public void typeOnField(String text, String fieldName) {
        WebElement element = PageManager.getPageElementByName(fieldName);
        element.sendKeys(text);
    }
}
