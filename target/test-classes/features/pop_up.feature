Feature: User interacts with catalog

  Scenario: User clicks on a catalog item
    Given User is on the catalog page
    When User clicks on the catalog item
    Then User should see the catalog item modal
