package com.eugenia.step_definitions;

import com.eugenia.managers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the URL contains the following keyword {string}")
    public void theURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(1000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains : " + collectKeyword);
    }

    @Given("The {string} is accessed")
    public void theIsAccessed(String collectedLink) {
        driver.get(collectedLink);
        System.out.println("The accessed link is: " + collectedLink);
    }

    @And("a thread sleep of {int} seconds is executed")
    public void aThreadSleepOfSecondsIsExecuted(int timeToSleep) {
        try {
            Thread.sleep(timeToSleep * 1000L);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Then("the following error message is displayed:")
    public void theFollowingErrorMessageIsDisplayed(List<String> errors) throws InterruptedException {
        Thread.sleep(500);
        errors.forEach(errorMessage -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath(".//*[contains(text(), '" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The error message is displayed.");
        });
    }

}
