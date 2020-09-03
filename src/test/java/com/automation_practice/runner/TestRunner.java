package com.automation_practice.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com"},
        tags = ("@Run")
)
@RunWith((Cucumber.class))
public class TestRunner {
}
