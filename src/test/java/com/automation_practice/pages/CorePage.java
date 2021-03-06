package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class CorePage extends AbsPage {

    @ElementAccessor(elementName = "Women category")
    @FindBy(xpath = "//a[contains(@title,'Women') and contains(@class, 'sf-with-ul')]")
    protected WebElement womenOptionMenuBar;

    @FindBy(xpath = "//a[contains(@class, 'sf-with-ul')]/../ul/li[1]/a[contains(@title,'T-shirts')]")
    protected WebElement tShirtWomenSubMenu;

    @FindBy(xpath = "//a[contains(@class, 'sf-with-ul')]/..//ul/li/a[contains(@title,'Blouses')]")
    protected WebElement blousesWomenSubMenu;

    @ElementAccessor(elementName = "Dresses category")
    @FindBy(xpath = "//ul[contains(@class, 'sf-menu clearfix menu-content sf-js-enabled sf-arrows')]/li[2]//a[@class='sf-with-ul' and @title='Dresses']")
    protected WebElement dressesOptionMenuBar;

    @ElementAccessor(elementName = "T-Shirt category")
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    protected WebElement tShirtOptionMenuBar;

    @FindBy(xpath = "/html/head/title")
    protected WebElement pageTitle;

    @ElementAccessor(elementName = "Sign In button")
    @FindBy(css = "header#header div.header_user_info > a")
    protected WebElement signInBtn;

    @ElementAccessor(elementName = "My Account button")
    @FindBy(xpath = "//a[@class='account']")
    private WebElement myAccountButton;

    public CorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWomenOptionMenuBar() {
        return womenOptionMenuBar;
    }

    public WebElement getBlousesWomenSubMenu() {
        return blousesWomenSubMenu;
    }

    public WebElement gettShirtOptionMenuBar() {
        return tShirtOptionMenuBar;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }
}