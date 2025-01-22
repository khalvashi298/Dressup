


Feature: Test PSP Online Product Search and Cart
  Background:
    Given  the browser is launched and "https://psp.ge" login page is opened

  Scenario: Search and Add Product to Cart
#    Given the browser is launched and PSP home page is opened
    When the user enters "ვიტამინი C - Vitamin C ფორთოხლით 20 შუშხუნა ტაბლეტი" in the search bar
    And clicks the search button
    Then the user should see the product in search results
    When the user adds the "<product>" to the cart
    Then the cart should contain the "<product>"

      | product                   |
      |  C - Vitamin C       |




