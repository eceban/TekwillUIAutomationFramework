package com.eugenia.page_objects;

import com.eugenia.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "input-firstname")
    private WebElement firstName_input;

    @FindBy (id = "input-lastname")
    private WebElement lastName_input;

    @FindBy (id = "input-email")
    private WebElement email_input;

    @FindBy (id = "input-password")
    private WebElement password_input;

    @FindBy (css = "input[value='1'][name='agree']")
    private WebElement privacy_toggleBar;

    @FindBy (css = "button[type='submit']")
    private WebElement continue_button;

    private String email;
    private String password;

    public void completeRegisterForm(String firstName, String lastName, String email, String password) {
        setEmail(email);
        setPassword(password);
        firstName_input.sendKeys(firstName);
        lastName_input.sendKeys(lastName);
        email_input.sendKeys(email);
        password_input.sendKeys(password);
        System.out.println("Register form was completed with email=" + email + " and password=" + password);
    }

    public void enablePrivacyToggle() {
        ScrollManager.scrollToElement(privacy_toggleBar);
        privacy_toggleBar.click();
        System.out.println("Privacy rules are accepted.");
    }

    public void submitButton() {
        ScrollManager.scrollToElement(continue_button);
        continue_button.click();
        System.out.println("Continue button was clicked.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
