package com.eugenia.page_objects;

import com.eugenia.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends Page{

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement userName_input;

    @FindBy(id = "input-password")
    WebElement password_input;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement logIn_button;

    public void completeLoginForm(String email, String password) {
        userName_input.sendKeys(email);
        password_input.sendKeys(password);
        System.out.println("Login form was completed.");
    }

    public void submitButton() {
        ScrollManager.scrollToElement(logIn_button);
        logIn_button.click();
        System.out.println("Log In button was clicked.");
    }
}
