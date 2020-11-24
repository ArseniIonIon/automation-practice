@checkout
Feature: Buy product

  @cleanCart
  Scenario: Adding product to card
    Given the 'AutomationPractice' page is displayed
    When the user goes to BEST_SELLERS products
    And add 'Printed Chiffon Dress' product to cart
    Then the product is successfully added to cart
    When user goes to checkout process
    Then the 'Summary' page is displayed
    And the 'Printed Chiffon Dress' is present on the card summary

  Scenario: Product checkout
    Given the 'AutomationPractice' page is displayed
    When the user goes to BEST_SELLERS products
    And add 'Blouse' product to cart
    Then the product is successfully added to cart
    When user goes to checkout process
    Then the 'Summary' page is displayed
    And the 'Blouse' is present on the card summary
    When user clicks on Checkout button
    Then the 'Login' page is displayed
    When user types "arseniion2@gmail.com" in 'Email field'
    And user types "1q2w3e4r" in 'Password field'
    And  user clicks on Log In button
    Then the 'Address' page is displayed
    When user clicks on Checkout button
    Then the 'Shipping' page is displayed
    When user clicks on Terms of service button
    And user clicks on Checkout button
    Then the 'Payment' page is displayed
    When user clicks on Pay by check button
    And user clicks on I confirm my order button
    Then order details are displayed
    When user clicks on Back to orders button
    Then the 'Orders' page is displayed
    And the order is present in the list





    




