Feature: Login functionality

  Scenario: User opens homepage and logs in successfully
    Given the browser is open and the "https://dressup.ge/" website is loaded
    And the user closes the pop-up
    When the user selects the login option
    And the user enters email "khalvashim2@gmail.com"
    And the user enters password "Batumi@2025"
    And the user clicks the login button
   Then the user should be successfully logged in

#    When the user clicks at the authentication icon
