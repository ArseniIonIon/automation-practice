@wishlist
Feature: Wishlist validation

  Background:
    Given the 'AutomationPractice' page is displayed
    And default user is logged in


  @ClearWishlist
  Scenario: One product is displayed in wishlist page
    Given user clicks on T-Shirt category
    And the 'T-Shirt' page is displayed
    And user clicks on list button
    When user adds Faded Short Sleeve T-shirts product to Wishlist
    Then popup with Added to your wishlist. message is displayed
    When user closes the popup
    And user clicks on My Account button
    When the 'MyAccount' page is displayed
    And user clicks on My Wishlist button
    And the 'Wishlist' page is displayed
    Then the default Wishlist table is displayed
    And the 'My wishlist' has 1 product
    When the user open My wishlist list
    Then the Faded Short Sleeve T-shirts is present into the list

    @ClearWishlist
    Scenario: Add product in new created Wishlist
      Given user clicks on My Wishlist button
      And the 'Wishlist' page is displayed
      When user types "testlist" in 'List field'
      And user clicks on Save button
      Then new wishlist with title testlist is displayed
      When user clicks on Dresses category
      And the 'Dresses' page is displayed
      And user clicks on list button
      And  user adds Blouse product to Wishlist
      Then popup with Added to your wishlist. message is displayed
      When user closes the popup
      And user clicks on My Account button
      When the 'MyAccount' page is displayed
      And user clicks on My Wishlist button
      And the 'Wishlist' page is displayed
      And the user open testlist list
      Then the Blouse is present into the list