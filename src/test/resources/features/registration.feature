Feature: Registration form visibility

  Background:
    Given the browser is open and the  "https://dressup.ge/" website is loaded

  Scenario: User opens the registration form successfully
    And the user closes the pop-up window
    When the user clicks on the user icon
    And the user closes the pop-up window again
    When clicks on the registration button
    Then the registration form should be visible
    And enters their email as "khalvashim@gmail.com"
    And enters their first name as "Maia"
    And enters their last name as "Khalvashi"
    And enters their personal number as "61009019835"
    And enters their password as "batumi@2025"
    And agrees to the terms and conditions
    And clicks the register button

