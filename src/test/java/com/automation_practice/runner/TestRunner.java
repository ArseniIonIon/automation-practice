package com.automation_practice.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.automation_practice"},
        tags = ("@wishlist"),
        plugin = {"pretty", "html:target/cucumber-report"}
)
public class TestRunner {

}
