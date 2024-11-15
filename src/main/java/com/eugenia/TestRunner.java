package com.eugenia;

import com.eugenia.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        String nameOfTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.stiri.md/");
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(nameOfTab);
        Thread.sleep(2000);
        //DriverManager.getInstance().getDriver().quit();
        driver.quit();
    }
}