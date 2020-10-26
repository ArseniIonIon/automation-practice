package com.automation_practice.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScenarioContext {

    private Map<ScenarioKeys,Object> data;
    private static ScenarioContext instance;

    private ScenarioContext() {
        this.data = new HashMap<>();
    }

    public static ScenarioContext getScenarioContext(){
        if (Objects.isNull(instance)){
            instance = new ScenarioContext();
        }
        return  instance;
    }

    public Object getData(ScenarioKeys key){
        return data.get(key);
    }

    public void saveData(ScenarioKeys key, Object object){
        data.put(key,object);
    }


}
