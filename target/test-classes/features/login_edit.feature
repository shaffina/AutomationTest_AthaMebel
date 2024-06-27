Feature: Update Description

  Scenario: Successfully updated description product
    Given User is logged in using admin account
    And user navigated to the update catalog page
    When user updates the product with valid details
    Then user should be redirected to all product page
