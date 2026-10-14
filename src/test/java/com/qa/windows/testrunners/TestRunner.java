package com.qa.windows.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featurefiles",
        glue = {
                "com.qa.windows.stepdefs",
                "com.qa.windows.hooks"
        },
        tags = "@smoke",
        plugin = {
                "pretty",
                "html:target/reports/cucumber.html",
                "json:target/reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        dryRun = false
//        stepNotifications = true

)
public class TestRunner extends AbstractTestNGCucumberTests {
}