package com.automation_practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class CorePage extends AbsPageFactory{

    @FindBy(xpath = "//a[contains(@title,'Women') and contains(@class, 'sf-with-ul')]")
    protected WebElement womenOptionMenuBar;
    @FindBy(xpath = "//a[contains(@class, 'sf-with-ul')]/../ul/li[1]/a[contains(@title,'T-shirts')]")
    protected  WebElement tShirtWomenSubMenu;
    @FindBy(xpath = "//a[contains(@class, 'sf-with-ul')]/..//ul/li/a[contains(@title,'Blouses')]")
    protected WebElement blousesWomenSubMenu;
    @FindBy(xpath = "//a[contains(@title,'Dresses') and contains(@class, 'sf-with-ul')]")
    protected    WebElement dressesOptionMenuBar;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    protected  WebElement tShirtOptionMenuBar;
    @FindBy (css = "header#header div.header_user_info > a")
    protected WebElement signInBtn;
    @FindBy(xpath = "/html/head/title")
    protected WebElement pageTitle;

    public CorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWomenOptionMenuBar() {
        return womenOptionMenuBar;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement gettShirtWomenSubMenu() {
        return tShirtWomenSubMenu;
    }

    public WebElement getBlousesWomenSubMenu() {
        return blousesWomenSubMenu;
    }

    public WebElement getDressesOptionMenuBar() {
        return dressesOptionMenuBar;
    }

    public WebElement gettShirtOptionMenuBar() {
        return tShirtOptionMenuBar;
    }

    public WebElement getPageTitle(){
        return pageTitle;
    }
}
