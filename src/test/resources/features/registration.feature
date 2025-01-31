Feature: Registration form visibility

  Background:
    Given the browser is open and the PSP website is loaded

  Scenario:
    When the user clicks on the user icon
    When clicks on the registration button
    And enters their first name as "მაია"
    And enters their last name as "ხალვაში"
    And enters their phone number as "995593797191"
    And enters their email as "khalvashim@gmail.com"
    And enters their password as "batumi@2025"
    And confirms their password as "batumi@2025"
    When agrees to the terms and conditions
    When clicks the register button


