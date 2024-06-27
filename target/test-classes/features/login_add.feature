Feature: Add Product

  Scenario: Successfully add new product
    Given User is logged in
    And user navigated to the add catalog page
    When user adds the product with valid details
    Then user should be redirected to dashboard page
