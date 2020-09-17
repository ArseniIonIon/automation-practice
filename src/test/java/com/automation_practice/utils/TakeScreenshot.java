package com.automation_practice.utils;

import com.automation_practice.browsers.Driver;
import gherkin.ast.Feature;
import gherkin.ast.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class TakeScreenshot {
    private String feature = Feature.class.getName();
    private String scenario = Scenario.class.getName();
    private final String EVICENDE_DIRECTORY = "src\\test\\resources\\evidence\\";
    private boolean directoryCreated = false;
    private String directoryPath;

    public LocalTime currentTime(){
        return LocalTime.now();
    }

    public void generateDirectory(){
        try{
            if(directoryCreated){
                directoryPath = EVICENDE_DIRECTORY + "_" + feature + "_" +currentTime();
                File file = new File(directoryPath);
                directoryCreated= true;
            }
        } catch (NullPointerException e){

            throw e;
        }
    }

    public void makeAShot(){
         try {
             Screenshot screenshot = new AShot().takeScreenshot(Driver.getInstance());
             ImageIO.write(screenshot.getImage(), "jpg", new File(directoryPath+"\\"+ scenario + "_" + currentTime()) );
         } catch (IOException e){
             System.out.println(e);
         }
    }

}
