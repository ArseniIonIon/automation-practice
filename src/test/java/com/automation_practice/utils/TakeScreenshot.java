package com.automation_practice.utils;

import com.automation_practice.browsers.Driver;
import gherkin.ast.Feature;
import gherkin.ast.Scenario;
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
    private String feature = Feature.class.getName();
    private String scenario = Scenario.class.getName();
    private final String EVICENDE_DIRECTORY = "src\\test\\resources\\evidence\\";
    private boolean directoryCreated = false;
    private String directoryPath;

    public String currentTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime time = LocalDateTime.now();
        return formatter.format(time);
    }

    public void generateDirectory() throws IOException {
        try{
            if(!directoryCreated){
                directoryPath = EVICENDE_DIRECTORY + "_" + feature + "_" + currentTime() ;
                Path path = Paths.get(directoryPath);
                Files.createDirectories(path);
                directoryCreated= true;
            }
        } catch (IOException e){

            throw e;
        }
    }

    public void makeAShot(){
         try {
             Screenshot screenshot = new AShot().takeScreenshot(Driver.getInstance());
             ImageIO.write(screenshot.getImage(), "png", new File(directoryPath +"\\" + scenario + "_" + currentTime() + ".png") );
         } catch (IOException e){
             System.out.println(e);
         }
    }

}
