Feature: Login flow test suits

  @runNow
  Scenario Outline: An error message is displayed when trying to log in with invalid details
    Given The "https://tekwillacademy-opencart.online/index.php?route=account/login&language=en-gb" is accessed
    And the login form is populated with the following data:
      | <email>    |
      | <password> |
    When the loginBtn is clicked
    Then the following error message is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email         | password |
      | test@test.com | !234Qwer |
      | .com          | !        |