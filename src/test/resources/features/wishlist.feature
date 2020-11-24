@wishlist
Feature: Wishlist validation

  Background:
    Given the 'AutomationPractice' page is displayed
    And the User clicks on Sign in
    And the 'Login' page is displayed
    When user types "arseniion2@gmail.com" in 'Email field'
    And  user types "1q2w3e4r" in "Password field"
    And user clicks on Sign In button


  @ClearWishlist
  Scenario: One porduct is displayed in wishlist page
    Given user clicks on T-Shirt category
    And the 'T-Shirt' page is displayed
    And user clicks on list button
    When user adds Faded Short Sleeve T-shirts product to Wishlist
    Then popup with Added to your wishlist. message is displayed
    When user closes the popup
    And the User clicks on My Account button
    When the 'MyAccount' page is displayed
    And user clicks on My Wishlist button
    Then the default Wishlist table is displayed
#    And the 'My wishlist' has 1 product
    When the user open My wishlist list
    Then the Faded Short Sleeve T-shirts is present into the list




