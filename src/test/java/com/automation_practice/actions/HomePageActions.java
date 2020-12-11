package com.automation_practice.actions;


import com.automation_practice.context.ScenarioContext;
import com.automation_practice.pages.AutomationPracticePage;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import static com.automation_practice.browsers.Driver.getInstance;
import static com.automation_practice.context.ScenarioContext.getScenarioContext;
import static com.automation_practice.context.ScenarioKeys.CURRENT_PAGE;

//TODO Can it be removed?
public class HomePageActions  {
    private ScenarioContext scenarioContext = getScenarioContext();
    Actions action = new Actions(getInstance());

    //TODO can it be moved somewhere?
    public void blouseCategorySelected(){
        AutomationPracticePage automationPracticePage = new AutomationPracticePage(getInstance());
        String pageTitle = automationPracticePage.getPageTitle().toString().trim();
        action.moveToElement(automationPracticePage.getWomenOptionMenuBar()).build().perform();
        automationPracticePage.getBlousesWomenSubMenu().click();
        scenarioContext.saveData(CURRENT_PAGE, automationPracticePage);
        Assert.assertEquals("Blouses - My Store",pageTitle);
    }

    public void tShirtCategorySelected(){

    }

}
