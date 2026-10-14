package com.qa.windows.utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class DriverManager {

    private static final ThreadLocal<WindowsDriver<?>> DRIVER =
            new ThreadLocal<>();

    private DriverManager() {
    }

    public static void initializeDriver() throws Exception {

        if (DRIVER.get() != null) {
            return;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Keep the capability that worked in your POC.
        capabilities.setCapability(
                "app",
                "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App"
        );

        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");

        WindowsDriver<?> driver = new WindowsDriver<>(
                new URL("http://127.0.0.1:4723/"),
                capabilities
        );

        driver.manage().timeouts()
                .implicitlyWait(0, TimeUnit.SECONDS);
        DRIVER.set(driver);
    }

    public static WindowsDriver<?> getDriver() {
        WindowsDriver<?> driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException(
                    "WindowsDriver is not initialized. " +
                            "Check the Cucumber hooks."
            );
        }

        return driver;
    }

    public static void quitDriver() {
        WindowsDriver<?> driver = DRIVER.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }
}
