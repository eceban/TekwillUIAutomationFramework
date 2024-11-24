package com.eugenia;

import com.eugenia.managers.DriverManager;
import com.eugenia.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestRunner1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String firstTab = driver.getWindowHandle();

// Access https://tekwillacademy-opencart.online/ site
        driver.get("https://tekwillacademy-opencart.online/");
        displayPageUrlTitle(driver);

// Access Register page
        WebElement MyAccountDropdown = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        MyAccountDropdown.click();
        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();
        displayPageUrlTitle(driver);

// Registration
        registration(driver);

// Log out
        loggingOut(driver);

// Log in
        //loggingIn(driver);

// Close the current tab
        driver.close();

        driver.switchTo().window(firstTab);
        displayPageUrlTitle(driver);

// Close the entire browser
        driver.quit();
    }


    private static void displayPageUrlTitle(WebDriver currentDriver) {
        System.out.println();
        System.out.println("The driver is on page: " + currentDriver.getCurrentUrl());
        System.out.println("The page tile is: " + currentDriver.getTitle());
    }

    private static void registration(WebDriver currentDriver) throws InterruptedException {

// Fill in Register form
        WebElement firstNameInput = currentDriver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = currentDriver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput = currentDriver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = currentDriver.findElement(By.cssSelector("#input-password"));
        String passwordData = RandomDataManager.getRandomPassword(4, 21, true, true, true);
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(passwordData);

// Enable toggle bar
        WebElement privacyToggleBar = currentDriver.findElement(By.name("agree"));
        ((JavascriptExecutor) currentDriver).executeScript("arguments[0].scrollIntoView(true);", privacyToggleBar);
        Thread.sleep(500);
        privacyToggleBar.click();

// Submit register form
        WebElement continueButton = currentDriver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(3000);
    }

    private static void loggingOut(WebDriver currentDriver) {
        WebElement MyAccountDropdown = currentDriver.findElement(By.xpath("//span[normalize-space()='My Account']"));
        MyAccountDropdown.click();
        WebElement logoutOption = currentDriver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']"));
        logoutOption.click();
        displayPageUrlTitle(currentDriver);
    }

}