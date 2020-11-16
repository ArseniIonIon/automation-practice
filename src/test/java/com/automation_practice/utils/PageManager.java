package com.automation_practice.utils;

import com.automation_practice.annotations.ElementAccessor;
import com.automation_practice.annotations.PageAccessor;
import com.automation_practice.browsers.Driver;
import com.automation_practice.context.ScenarioContext;
import com.automation_practice.context.ScenarioKeys;
import com.automation_practice.pages.AbsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PageManager {
    private static final List<Class<?>> PAGE_CLASSES = new ArrayList<>();
    static PropertyParser propertyParser = new PropertyParser();
    private static String path_to_packages = propertyParser.getProps("path_to_packages");
    private static String path_to_pages  = propertyParser.getProps("path_to_pages");

    public static void initPageClasses() { File directory = new File(path_to_packages);
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                Class<?> clazz = Class.forName(path_to_pages + file.getName().replace(".java", ""));
                PAGE_CLASSES.add(clazz);
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static AbsPage getPage(String pageName) {
        AbsPage abstractPage = null;
        for (Class claz : PAGE_CLASSES) {
            PageAccessor annotation = (PageAccessor) claz.getAnnotation(PageAccessor.class);


            if (annotation != null && pageName.equals(annotation.pageName())) {
                try {
                    Constructor constructor = claz.getConstructor(WebDriver.class);
                    abstractPage = (AbsPage) constructor.newInstance(Driver.getInstance());
                    // to do, add postinit
                    break;
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        if (abstractPage == null) {
            throw new RuntimeException(String.format("Couldn't find a page with page name [%s]", pageName));
        }
        return abstractPage;
    }

    private static Field[] getDeclaredFields(Object obj) {
        Field[] declaredFieldsFromSuper = obj.getClass().getSuperclass().getDeclaredFields();
        Field[] declaredFields = obj.getClass().getDeclaredFields();

        return Stream.concat(Arrays.stream(declaredFieldsFromSuper), Arrays.stream(declaredFields))
                .toArray(Field[]::new);
    }


    public static WebElement getPageElementByName(String name) {
        ScenarioContext scenarioContext = ScenarioContext.getScenarioContext();
        Object currentPage = scenarioContext.getData(ScenarioKeys.CURRENT_PAGE);

        Field[] fields = getDeclaredFields(currentPage);

        try {
            for (Field field : fields) {
                ElementAccessor annotation = field.getAnnotation(ElementAccessor.class);

                if (annotation == null) {
                    continue;
                } else if (annotation.elementName().equals(name)) {
                    field.setAccessible(true);
                    WebElement targetElem = (WebElement) field.get(currentPage);
                    field.setAccessible(false);
                    return targetElem;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("No field found with expected name : " + name);
    }

}
