package com.qa.windows.pages;

import com.qa.windows.utils.ElementUtils;
import org.openqa.selenium.By;

public class CalculatorPage {

    private final By numberOne =
            By.name("One");

    private final By numberTwo =
            By.name("Two");

    private final By plusButton =
            By.name("Plus");

    private final By equalsButton =
            By.name("Equals");

    private final By resultDisplay =
            By.xpath("//*[@AutomationId='CalculatorResults']");

    public void addOneAndTwo() {
        ElementUtils.click(numberOne);
        ElementUtils.click(plusButton);
        ElementUtils.click(numberTwo);
        ElementUtils.click(equalsButton);
    }

    public String getResult() {
        return ElementUtils.getText(resultDisplay);
    }
}