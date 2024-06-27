Feature: Admin login

  Scenario: Admin logs in with valid credentials
    Given The admin is on the login page
    When The admin enters the email "admin@gmail.com"
    And The admin enters the password "rahasia"
    And The admin clicks the login button
    Then The admin should be logged in successfully
