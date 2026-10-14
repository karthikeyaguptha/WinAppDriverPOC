package com.qa.windows.utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class WaitUtils {

    private static final int TIMEOUT_SECONDS = 10;

    private WaitUtils() {
    }

    private static WebDriverWait waitForElement() {
        return new WebDriverWait(
                DriverManager.getDriver(),
                TimeUnit.SECONDS.toMillis(TIMEOUT_SECONDS)
        );
    }

    public static WebElement visible(By locator) {
        return waitForElement().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement clickable(By locator) {
        return waitForElement().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static boolean isVisible(By locator) {
        try {
            visible(locator);
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}