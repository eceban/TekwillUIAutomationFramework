package com.eugenia.step_definitions;

import com.eugenia.managers.DriverManager;
import com.eugenia.managers.RandomDataManager;
import com.eugenia.page_objects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();
        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, password);
    }

    @And("the privacy toggle bar is enabled")
    public void thePrivacyToggleBarIsEnabled() {
        registerPage.enablePrivacyToggle();
    }

    @When("the continueButton is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.submitButton();
    }
}
