package com.eugenia;

import com.eugenia.managers.DriverManager;
import com.eugenia.managers.RandomDataManager;
import com.eugenia.page_objects.AccountPage;
import com.eugenia.page_objects.HomePage;
import com.eugenia.page_objects.LogInPage;
import com.eugenia.page_objects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);


// Registration
        homePage.navigateToRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeRegisterForm(RandomDataManager.getRandomFirstName(),
                                            RandomDataManager.getRandomLastName(),
                                            RandomDataManager.getRandomEmail(),
                                            RandomDataManager.getRandomPassword(4, 8, true, true, true)
                                        );
        registerPage.enablePrivacyToggle();
        registerPage.submitButton();

        Thread.sleep(2000);

// Log Out
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logOut();

// Log In
        homePage.navigateToLoginPage();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.completeLoginForm(registerPage.getEmail(), registerPage.getPassword());
        logInPage.submitButton();

        driver.close();
        System.out.println("Driver is closed and test is finished");
    }
}
