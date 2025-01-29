Feature: PSP website functionality testing

  Background:
    Given the browser is open and "https://psp.ge/" is loaded

    Feature: User Login

      Scenario: User Login

        When the user clicks on the login icon
        And enters the email as "mkhalvashi2@gmail.com"
        And enters the password as "batumi2025"
        And clicks on the login button
        Then the user should be successfully logged in


  Feature:
    Background:
      Given the user is on the homepage

    Scenario: User Registration
    Given the user is on the homepage
    When the user clicks on the user icon
    And clicks on the registration button
    And enters their first name as "მაია"
    And enters their last name as "ხალვაში"
    And enters their phone number as "593797191"
    And enters their email as "khalvashim@gmail.com"
    And enters their password as "batumi@2025"
    And confirms their password as "batumi@2025"
    And agrees to the terms and conditions
    And clicks the register button
    Then the user should be successfully registered




  Feature: Add Product to Cart and Validate

    Background:
    Given the user is on the homepage

  Scenario: Add Product to Cart and Validate

    When the user searches for a product with the keyword "კრემი"
    And selects the first product from the results
    And adds the product to the cart
    And the user is redirected to the login page
    And the user enters the email as "testuser@gmail.com"
    And the user enters the password as "testpassword123"
    And the user clicks on the login button
    And the user chooses the city "ბათუმი"
    Then the product should be successfully added to the cart
    And the user should see the product in their cart
