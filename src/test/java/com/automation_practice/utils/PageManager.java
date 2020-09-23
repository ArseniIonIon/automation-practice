package com.automation_practice.utils;

import com.automation_practice.annotations.ElementAcccessot;
import com.automation_practice.annotations.PageAccessor;
import com.automation_practice.browsers.Driver;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.AbsPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class PageManager {
    private static final String PATH_TO_PAGE_PAKAGES_1 = "src\\test\\java\\com\\automation_practice\\pages\\";
    private static final String PATH_TO_PAGE_PAKAGES = "com.automation_practice.pages.";


    private static final List<Class<?>> PAGE_CLASSES = new ArrayList<>();

    public static void initPageClasses() {
        File directory = new File(PATH_TO_PAGE_PAKAGES_1);
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                Class<?> clazz = Class.forName(PATH_TO_PAGE_PAKAGES + file.getName().replace(".java", ""));
                PAGE_CLASSES.add(clazz);
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static AbsPageFactory getPage(String pageName) {
        AbsPageFactory abstractPage = null;
        for (Class claz : PAGE_CLASSES) {
            PageAccessor annotation = (PageAccessor) claz.getAnnotation(PageAccessor.class);


            if (annotation!=null && pageName.equals(annotation.pageName()) ){
                try {
                    Constructor constructor = claz.getConstructor(WebDriver.class);
                    abstractPage = (AbsPageFactory) constructor.newInstance(Driver.getInstance());
                    // to do, add postinit
                    break;
                } catch (NoSuchMethodException |InstantiationException |IllegalAccessException| InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        if (abstractPage == null){
            throw new RuntimeException(String.format("Couldn't find a page with page name [%s]", pageName));
        }
        return abstractPage;
    }

    public static WebElement getPageElementByName(String name) throws IllegalAccessException {
        ScenarioContext scenarioContext =  ScenarioContext.getScenarioContext();
        Object currentPage = scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);

        Field[] declaredFields = currentPage.getClass().getDeclaredFields();


        try {
            for (Field field:declaredFields) {
                ElementAcccessot annotation = field.getAnnotation(ElementAcccessot.class);
                field.setAccessible(true);

                if (annotation == null){
                    continue;
                }else if (annotation.elementName().equals(name)){

                    return  (WebElement) field.get(currentPage);
                }
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        throw new RuntimeException("No field found with expected name : " + name);
    }

    public static AbsPageFactory getPageByName(String pageName) {
        AbsPageFactory abstractPage = null;
        try {
            Class<?> cl = Class.forName(PATH_TO_PAGE_PAKAGES + pageName + "Page");
            Constructor constructor = cl.getConstructor(WebDriver.class);
            abstractPage = (AbsPageFactory) constructor.newInstance(Driver.getInstance());
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return abstractPage;
    }
}
