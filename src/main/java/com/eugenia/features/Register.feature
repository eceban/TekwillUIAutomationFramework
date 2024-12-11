Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration with valid data
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register Page is accessed from the Home Page buttons
    And the register form is populated with data
    And the privacy toggle bar is enabled
    When the continueButton is clicked
    Then the URL contains the following keyword "success"

  @run
  Scenario: The system keeps the user on Register page when registering using valid data without accepting the privacy rules
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register Page is accessed from the Home Page buttons
    And the register form is populated with data
#    And the privacy toggle bar is enabled
    When the continueButton is clicked
    Then the URL contains the following keyword "register"

    @runNow
  Scenario Outline: Error message is displayed when registering with invalid password length
    Given The "https://tekwillacademy-opencart.online/" is accessed
    And Register Page is accessed from the Home Page buttons
    And register form is populated as following:
      | firstName | <firstName>         |
      | lastName  | <lastName> |
      | email     | <email>    |
      | password  | <password> |
    And a thread sleep of 5 seconds is executed
    When the continueButton is clicked
    Then the following error message is displayed:
      | <errorMessage>                                 |
      | Warning: You must agree to the Privacy Policy! |
      Examples:
        | firstName | lastName                                | email  | password | errorMessage                                    |
        | RANDOM    | $%%123456789012345678901234567890123_+= | random | random   | First Name must be between 1 and 32 characters! |
        | RANDOM    | 123456789012345678901234567890123       | random | random   | Last Name must be between 1 and 32 characters!  |
        | RANDOM    | random                                  | #      | random   | E-Mail Address does not appear to be valid!     |
        | RANDOM    | random                                  | random | 123      | Password must be between 4 and 20 characters!   |

