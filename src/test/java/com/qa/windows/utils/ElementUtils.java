package com.qa.windows.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class ElementUtils {

    private ElementUtils() {
    }

    public static void click(By locator) {
        WaitUtils.clickable(locator).click();
    }

    public static void enterText(By locator, String text) {
        WebElement element = WaitUtils.visible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By locator) {
        return WaitUtils.visible(locator).getText();
    }

    public static boolean isDisplayed(By locator) {
        return WaitUtils.isVisible(locator);
    }

    public static void pressKeys(CharSequence... keys) {
        DriverManager.getDriver().getKeyboard().sendKeys(keys);
    }
}