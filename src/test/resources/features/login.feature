Feature: User Login

  Background:
    Given the browser is open and "https://psp.ge/" is loaded

  Scenario: User Login
    When the user clicks on the login icon
    And enters the email as "mkhalvashi2@gmail.com"
    And enters the password as "batumi2025"
    When clicks the login button
    Then the user should be successfully logged in
