Feature: SauceDemo website functionality testing with valid and invalid login flow


  Background:
    Given  the browser is launched and "https://www.saucedemo.com" login page is opened

  Scenario Outline: successful login and verifying cart functionality for different user
    When the user enters valid username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should be redirected to the Products page "https://www.saucedemo.com/inventory.html"
    And the user adds "<product>" to the cart
    And navigates to the cart page
    And The cart should contains "<product>"

    Examples:
      | username              | password       | product                   |
      | standard_user         | secret_sauce   | Sauce Labs Backpack       |
      | problem_user          | secret_sauce   | Sauce Labs Bike Light     |
      | performance_glitch_user    | secret_sauce   | Sauce Labs Bolt T-Shirt   |



