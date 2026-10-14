package com.qa.windows.hooks;

import com.qa.windows.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        DriverManager.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot)
                        DriverManager.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failure Screenshot"
                );
            }
        } catch (Exception e) {
            System.err.println(
                    "Unable to capture screenshot: " + e.getMessage()
            );
        } finally {
            DriverManager.quitDriver();
        }
    }
}