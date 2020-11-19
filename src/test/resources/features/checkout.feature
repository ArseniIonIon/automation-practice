@checkout
Feature: Buy product

  Scenario: Product checkout
    Given the 'AutomationPractice' page is displayed
    When the user goes to Popular products
    And add 'Blouse' product to cart
    Then the product is successfully added to cart

    When user goes to checkout process
    Then the 'Checkout' page is displayed
    And the 'Blouse' is present on the card summary

    When user clicks on Checkout button
    Then the 'Login' page is displayed
    When user types "arseniion2@gmail.com" in email field
    And  types "1q2w3e4r" in password field
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
    And the product is present in the list

  @cleanCart
  Scenario: Adding product to card.
    Given the 'AutomationPractice' page is displayed
    When the user goes to Best Sellers products
    And add 'Faded Short Sleeve T-shirts' product to cart
    Then the product is successfully added to cart

    When user goes to checkout process
    Then the 'Checkout' page is displayed
    And the 'Faded Short Sleeve T-shirts' is present on the card summary



    




