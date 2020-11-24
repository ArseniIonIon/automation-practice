package com.automation_practice.actions;

import com.automation_practice.browsers.Driver;
import com.automation_practice.utils.PageManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonActions {

    private final static int TIMEOUT = 10;

    static void wait(int seconds) {
        Driver.getInstance().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    static void moveToElement(WebElement element) {
        Actions action = new Actions(Driver.getInstance());
        action.moveToElement(element);
        action.perform();
    }

    public static void waitUntilElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), TIMEOUT);
        wait.until((ExpectedCondition<Boolean>) arg -> element.isDisplayed());
//        ExpectedCondition elementIsDisplayed = (ExpectedCondition<Boolean>) arg0 -> {
//            try {
//                element.isDisplayed();
//                return true;
//            } catch (NoSuchElementException | StaleElementReferenceException e) {
//                return false;
//            }
//        };

//        ExpectedCondition elementIsDisplayed = (ExpectedCondition<Boolean>) arg0 -> element.isDisplayed();
//        wait.until(elementIsDisplayed);
    }

    public static void scrollToElement(WebElement element) {
        WebDriver driver = Driver.getInstance();
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
