package com.eugenia.step_definitions;

import com.eugenia.managers.DriverManager;
import com.eugenia.page_objects.LogInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LogInPage logInPage = new LogInPage(driver);

    @And("the login form is populated with the following data:")
    public void theFromIsClicked(List<String> colectedDataList) {
        logInPage.completeLoginForm(colectedDataList.get(0), colectedDataList.get(1));
    }

    @When("the loginBtn is clicked")
    public void theLoginBtnIsClicked() {
        logInPage.submitButton();
    }

}
