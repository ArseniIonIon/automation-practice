package com.automation_practice.utils;

import com.automation_practice.browsers.Driver;
import com.automation_practice.steps.LoginSteps;
import gherkin.ast.Feature;
import gherkin.ast.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeScreenshot {

    private final String EVICENDE_DIRECTORY = "target\\evidence\\";
    private boolean directoryCreated = false;
    private String directoryPath;
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);


    public String currentTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime time = LocalDateTime.now();
        return formatter.format(time);
    }

    public void generateDirectory(String featureName) throws IOException {
        try{
            if(!directoryCreated){
                directoryPath = EVICENDE_DIRECTORY + "_" + featureName + "_" + currentTime() ;
                Path path = Paths.get(directoryPath);
                Files.createDirectories(path);
                directoryCreated= true;
            }
        } catch (IOException e){
            logger.error("The directory was not created");
            throw e;
        }
    }

    public void makeAShot(String scenarioName){
         try {
             Screenshot screenshot = new AShot().takeScreenshot(Driver.getInstance());
             ImageIO.write(screenshot.getImage(), "png", new File(directoryPath +"\\" + scenarioName + "_" + currentTime() + ".png") );
         } catch (IOException e){
             logger.error("Could not create/save screenshot");
             System.out.println(e);
         }
    }

}