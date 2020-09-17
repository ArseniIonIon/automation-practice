# new feature
# Tags: optional
@checkout
Feature: Buy product

  Scenario: Product checkout
    Given the AutomationPractice page is displayed
    When the user goes to Popular products
    And add Blouse product to cart
    Then the product is successfully added to cart

    When user goes to checkout process
    Then the Checkout page is displayed
    And the Blouse is present on the card summary

    When user clicks on checkout process
    Then the Login page is displayed
    When user types "arseniion2@gmail.com" in email field
    And  types "1q2w3e4r" in password field
    And  user clicks on SignIn btn
 #   Then the Addresses tab is displayed
    When user clicks on checkout process
    #  Then the Shipping tab is displayed

    




