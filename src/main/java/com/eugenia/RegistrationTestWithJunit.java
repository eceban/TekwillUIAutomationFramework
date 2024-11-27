package com.eugenia;

import com.eugenia.managers.DriverManager;
import com.eugenia.managers.RandomDataManager;
import com.eugenia.page_objects.HomePage;
import com.eugenia.page_objects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationTestWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTheTest(){
        System.out.println("This methods is run before all the tests from this class");
    }

    @BeforeEach
    public void beforeEachTest(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
    }

    @Test
   @DisplayName("User is redirected to Account page when registering with valid data")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {
        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.enablePrivacyToggle();
        registerPage.submitButton();

        Thread.sleep(2000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contain the Success keyword");
    }

    @Test
    @DisplayName("The user remains on the Register page when registering without accepting the terms and conditons")
    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {
        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, password);
        registerPage.submitButton();

        Assertions.assertTrue(driver.getCurrentUrl().contains("register"), "The page url has the keyword register");
    }

    @Test
    @DisplayName("Navigate to Login page from Register Page")
    public void navigateToLoginPageFromRegisterPage(){
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @AfterEach
    public void afterEachTest(){
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public static void afterAllTheTests(){
        System.out.println("This methods is executed after all the tests!");
    }
}
