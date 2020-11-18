package com.automation_practice.actions;

import com.automation_practice.browsers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonActions {

    //public static WebDriver driver = Driver.getInstance();

    public static void wait(int seconds){
        Driver.getInstance().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void moveToElement(WebElement element) {
        Actions action = new Actions(Driver.getInstance());
        action.moveToElement(element);
        action.perform();
    }
    public static void waitVisible(WebElement element,int second){
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(),second);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollToElement(WebElement element){
        WebDriver driver = Driver.getInstance();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getChildElement(WebElement element) {
        return element.findElement(By.xpath("."));
    }
}
