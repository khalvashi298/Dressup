Feature: SauceDemo website functionality testing with valid and invalid login flow


  Background:
    Given  the browser is launched and "https://www.saucedemo.com" login page is opened

#    ავტორიზაცია და პროდუქტის კალათაში დამატება

  Scenario: :successful login and adding a product to cart
    When  the user enters valid username "standard_user" and password "secret_sauce"
    And  the user clicks on the login button
    Then  the user should be redirected to the product page "https://www.saucedemo.com/inventory.html"


#    Scenario: successful login and adding a product to cart
#    When  the user enters valid username "standard_user" and password "secret_sauce"
#      And  the user clicks on the login button
#    And  the user adds a product to the cart by clicking on the "Add to cart" button
#    Then  the user should see the product in the cart "https://www.saucedemo.com/inventory-item.html?id=4"

#
##
#
  Scenario Outline: successful login and verifying cart functionality for different user
    When the user enters valid username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should be redirected to the product page "https://www.saucedemo.com/inventory.html"
    And the user adds "<product>" to the cart
    And navigates to the cart page
    And The cart should contains "<product>"

    Examples:
      | username              | password       | product                   |
      | standard_user         | secret_sauce   | Sauce Labs Backpack       |
      | problem_user          | secret_sauce   | Sauce Labs Bike Light     |
      | performance_glitch    | secret_sauce   | Sauce Labs Bolt T-Shirt   |



