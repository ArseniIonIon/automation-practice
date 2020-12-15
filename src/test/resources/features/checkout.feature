@checkout1
Feature: Buy product

  @cleanCart
  Scenario: Adding product to card
    Given the 'AutomationPractice' page is displayed
    When the user goes to BEST_SELLERS products
    And add 'Printed Chiffon Dress' product to cart
    Then the product is successfully added to cart
    When user goes to checkout process
    Then the 'Summary' page is displayed
    And the 'Printed Chiffon Dress' is present on the cart summary

  @checkout
  Scenario: Product checkout
    Given the 'AutomationPractice' page is displayed
    When the user goes to BEST_SELLERS products
    And add 'Blouse' product to cart
    Then the product is successfully added to cart
    When user goes to checkout process
    Then the 'Summary' page is displayed
    And the 'Blouse' is present on the cart summary
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
    When user selects payment type PAY_BY_BANK

    And user clicks on I confirm my order button
    Then order details are displayed
    When user clicks on Back to orders button
    Then the 'Orders' page is displayed
    And the order is present in the list

  Scenario Outline: Products checkout
    Given the 'AutomationPractice' page is displayed
    When the user goes to <Product Category> products
    And add '<Product>' product to cart
    Then the product is successfully added to cart
    When user goes to checkout process
    Then the 'Summary' page is displayed
    And the '<Product>' is present on the cart summary
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
    When user selects payment type <Payment Type>
    And user clicks on I confirm my order button
    Then order details are displayed
    When user clicks on Back to orders button
    Then the 'Orders' page is displayed
    And the order is present in the list

    Examples:
      | Product Category | Product               | Payment Type |
      | BEST_SELLERS     | Blouse                | PAY_BY_BANK  |
      | POPULAR          | Printed Chiffon Dress | PAY_BY_CHECK |

    @cleanCart
    Scenario: Validate product price on checkout
      Given the 'AutomationPractice' page is displayed
      And user clicks on Women category
      And the 'Women' page is displayed
      And user clicks on list button
      And user adds Blouse product to cart
      And user clicks on Continue Shopping button
      And user adds Faded Short Sleeve T-shirts product to cart
      And user clicks on Add to cart button
      Then the 'Summary' page is displayed
      And the 'Blouse' is present on the cart summary
      And the 'Faded Short Sleeve T-shirts' is present on the cart summary
      And the price is equal to 43.51
      