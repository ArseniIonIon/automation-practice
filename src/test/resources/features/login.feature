@login
Feature: Login
   # The user wants to login on automationpractice

  Background:
    Given user clicks on Sign In button
    And the 'Login' page is displayed
    And the 'Email field' is empty
    And the 'Password field' is empty

  Scenario:Error on empty fields
    When user clicks on Log In button
    Then the error message: "An email address required." is displayed

  Scenario: Wrong Password
    When user types "arseniion2@gmail.com" in 'Email field'
    And user types "12345" in 'Password field'
    And user clicks on Log In button
    Then the error message: "Authentication failed." is displayed

  Scenario: Login successfully
    When user types "arseniion2@gmail.com" in 'Email field'
    And user types "1q2w3e4r" in 'Password field'
    And user clicks on Log In button
    Then the 'MyAccount' page is displayed

