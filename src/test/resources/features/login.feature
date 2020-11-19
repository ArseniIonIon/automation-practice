@login
Feature: Login
   # The user wants to login on automationpractice

  Background:
    Given user clicks on Sign In button
    And the 'Login' page is displayed
    And the field email is empty
    And the field password is empty

  Scenario:Error on empty fields
    When user clicks on Log In button
    Then the error message: "An email address required." is displayed

  Scenario: Wrong Password
    When user types "arseniion2@gmail.com" in email field
    And types "12345" in password field
    And user clicks on Log In button
    Then the error message: "Authentication failed." is displayed

  Scenario: Login successfully
    When user types "arseniion2@gmail.com" in email field
    And  types "1q2w3e4r" in password field
    And user clicks on Log In button
    Then the 'MyAccount' page is displayed


