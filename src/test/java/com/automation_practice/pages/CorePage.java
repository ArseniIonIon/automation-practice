package com.automation_practice.pages;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public abstract class CorePage extends AbsPage {

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

    @FindBy(xpath = "/html/head/title")
    protected WebElement pageTitle;

    @ElementAccessor(elementName = "Sign in")
    @FindBy (css = "header#header div.header_user_info > a")
    protected WebElement signInBtn;


    public CorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public void setSignInBtn(WebElement signInBtn) {
        this.signInBtn = signInBtn;
    }

    public WebElement getWomenOptionMenuBar() {
        return womenOptionMenuBar;
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
