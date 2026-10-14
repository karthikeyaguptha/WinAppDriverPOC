package com.qa.windows.stepdefs;

import com.qa.windows.pages.CalculatorPage;

import com.qa.windows.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.testng.Assert;

public class CalculatorSteps {

    private final CalculatorPage calculatorPage =
            new CalculatorPage();

    @Given("the Calculator application is launched")
    public void calculatorIsLaunched() {
        Assert.assertNotNull(
                DriverManager.getDriver(),
                "Calculator driver must be initialized"
        );
    }

    @When("I add one and two")
    public void addNumbers() {
        calculatorPage.addOneAndTwo();
    }

    @Then("the Calculator result should be {string}")
    public void verifyResult(String expected) {
        String actual = calculatorPage.getResult();

        Assert.assertTrue(
                actual.contains(expected),
                "Expected result to contain " + expected
                        + " but was " + actual
        );
    }
}