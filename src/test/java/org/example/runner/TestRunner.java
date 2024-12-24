package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//package org.example.runner;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//
//@CucumberOptions(
//        features = "src/test/resources/features",
//        glue = "org.example.StepDefinitions",
//        plugin = {"pretty", "html:target/cucumber-reports.html"}
//)
//public class TestRunner  extends AbstractTestNGCucumberTests {
//
//}
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports/cucumber.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
