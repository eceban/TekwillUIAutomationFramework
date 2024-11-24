package com.eugenia.page_objects;

import com.eugenia.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logOut_button;

    public void logOut() {
        ScrollManager.scrollToElement(logOut_button);
//        myAccount_dropDown.click();
        logOut_button.click();
        System.out.println("Log Out button was clicked.");
    }
}
