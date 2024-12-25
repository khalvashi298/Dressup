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

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SauceSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();

        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
         wait= new WebDriverWait(driver, Duration.ofSeconds(10));
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement usernameElement = driver.findElement(By.id("user-name"));
        usernameElement.clear();
        usernameElement.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement passwordElement= driver.findElement(By.id("password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);

    }
    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

    }


    @Then("the user should be redirected to the Products page {string}")
    public void theUserShouldBeRedirectedToTheProductsPage(String expectedUrl) {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, expectedUrl);
    }

    @And("the user adds {string} to the cart")
    public void theUserAddsToTheCart(String product) {
        product = product.toLowerCase().replace(" ", "-");
        String productXpath = "//button[@id='add-to-cart-" + product + "']";
        driver.findElement(By.xpath (productXpath)).click();
    }

    @And("navigates to the cart page")
    public void navigatesToTheCartPage() {
        driver.findElement(By.xpath(" //a[@class='shopping_cart_link']")).click();
    }
    @And("The cart should contains {string}")
    public void theCartShouldContains(String product) {
        WebElement findProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        findProduct.getText();


    }


}





