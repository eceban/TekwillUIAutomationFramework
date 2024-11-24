package com.eugenia.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    protected WebElement myAccount_dropDown;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement register_option;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    protected WebElement login_option;

    public void navigateToRegisterPage() {
        myAccount_dropDown.click();
        register_option.click();
        System.out.println("Header->MyAccount drop-down->Register option selected");
    }

    public void navigateToLoginPage() {
        myAccount_dropDown.click();
        login_option.click();
        System.out.println("Header->MyAccount drop-down->LogIn option selected");
    }
}
