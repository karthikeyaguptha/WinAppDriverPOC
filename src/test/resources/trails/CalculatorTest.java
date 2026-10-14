package trails;

import java.net.URL;
import java.net.MalformedURLException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {

    private WiniumDriver app = null;
    private DesktopOptions options;

    private String CALC_PATH =
            "C:\\Windows\\System32\\calc.exe";

    private String WINIUM_PATH =
            "http://localhost:9999";

    Calculator calc;

    @BeforeTest
    public void startCalculator() throws MalformedURLException {

        options = new DesktopOptions();
        options.setApplicationPath(CALC_PATH);

        app = new WiniumDriver(
                new URL(WINIUM_PATH), options);

        calc = new Calculator(app);
    }

    @Test
    public void add() {
        Assert.assertEquals(calc.add(7, 5), "12");
    }

    @Test
    public void subtract() {
        Assert.assertEquals(calc.subtract(7, 5), "2");
    }

    @Test
    public void multiply() {
        Assert.assertEquals(calc.multiply(7, 5), "35");
    }
}