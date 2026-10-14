package trails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class Calculator {

    private WiniumDriver app;

    public Calculator(WiniumDriver app) {
        this.app = app;
    }

    public String add(int i, int i1) {
        return calculate(i, "+", i1);
    }

    public String subtract(int i, int i1) {
        return calculate(i, "-", i1);
    }

    public String multiply(int i, int i1) {
        return calculate(i, "*", i1);
    }

    private String calculate(int num1, String operator, int num2) {

        WebElement calculatorWindow =
                app.findElement(By.name("trails.Calculator"));

        String expression;

        switch (operator) {
            case "+":
                expression = num1 + "+" + num2 + "=";
                break;

            case "-":
                expression = num1 + "-" + num2 + "=";
                break;

            case "*":
                expression = num1 + "*" + num2 + "=";
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported operator: " + operator);
        }

        calculatorWindow.sendKeys(expression);

        WebElement resultElement =
                app.findElement(By.id("CalculatorResults"));

        String resultText = resultElement.getText();

        // Example: "Display is 12"
        return resultText.replace("Display is ", "").trim();
    }
}