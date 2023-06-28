Feature: Register Flow Feature File

@Regression @Smoke
  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage buttons
    When The registration form is populated with valid random data
    And The privacyPolicyToggle is enable
    And continueButton is clicked
    Then The new page url contains "=account/success&l" keyword

  Scenario: User remains on Register Page when registering without accepting the privacy policy agreement
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage buttons
    When The registration form is populated with valid random data
    And The privacyPolicyToggle is enable
    Then The new page url contains "register" keyword

  @Regression
  Scenario: User remains on Register Page when privacy conditions are not accepted during the registration flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage buttons
    When The registration form is populated with valid random data
    And continueButton is clicked
    Then The new page url contains "register" keyword