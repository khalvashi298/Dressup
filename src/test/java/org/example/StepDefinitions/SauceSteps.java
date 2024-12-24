package org.example.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.sql.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class SauceSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {

        driver.quit();
    }

    @Given("the browser is launched and {string} login page is opened")
    public void theBrowserIsLaunchedAndLoginPageIsOpened(String baseUrl) {

        driver.get(baseUrl);
    }

    @When("the user enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
//
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


    }

    @Then("the user should be redirected to the product page {string}")
    public void theUserShouldBeRedirectedToTheProductPage(String expectedUrl) {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, expectedUrl);

//        String title = driver.getTitle();
////        System.out.println("Title:"  + title);
//        String url = driver.getCurrentUrl();
//        System.out.println(" url is " + url);;
    }




//    @And("the user adds {string}  to the cart")
//    public void theUserAddsToTheCart(String product) {
//        product = product.toLowerCase().replace(" ", "-");
//        String productXpath = "//button[@id='add-to-cart-sauce-labs-" + product + "']";
//        driver.findElement(By.xpath (productXpath)).click();
//
//    }

    @And("navigates to the cart page")
    public void navigatesToTheCartPage() {
        driver.findElement(By.xpath(" //a[@class='shopping_cart_link']")).click();
    }

    @And("The cart should contains {string}")
    public void theCartShouldContains(String product) {
        WebElement findProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        findProduct.getText();
        Assert.assertEquals(findProduct.getText(), product);

    }

    @And("the user adds {string} to the cart")
    public void theUserAddsToTheCart(String product) {
        product = product.toLowerCase().replace(" ", "-");
//        String productXpath = "//button[@id='add-to-cart-sauce-labs-" + product + "']";
        String productXpath="//button[@id='add-to-cart-sauce-labs-backpack']"
        driver.findElement(By.xpath (productXpath)).click();


    }

    @And("the user adds a product to the cart by clicking on the {string} button")
    public void theUserAddsAProductToTheCartByClickingOnTheButton(String product) {
        product = product.toLowerCase().replace(" ", "-");
        String productXpath = "//button[@id='add-to-cart-sauce-labs-" + product + "']";
        driver.findElement(By.xpath (productXpath)).click();
    }

    @Then("the user should see the product in the cart {string}")
    public void theUserShouldSeeTheProductInTheCart(String product) {
        WebElement findProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        findProduct.getText();
        Assert.assertEquals(findProduct.getText(), product);
    }
}




//    @Then("the user should see the product in the cart {string}")
//    public void theUserShouldSeeTheProductInTheCart(String  arg0) {
//    }
//
//    @And("the user adds a product to the cart by clicking on the {string} button")
//    public void theUserAddsAProductToTheCartByClickingOnTheButton(String arg0) {
//    }

