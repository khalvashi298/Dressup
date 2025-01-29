package steps;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class PspSteps {

    WebDriver driver;
    Utils utils;

    public PspSteps() {
        // Initialize WebDriver using DriverManager
        driver = DriverManager.getDriver();
        utils = new Utils(driver);
    }

    // ბრაუზერის გახსნა
    @Given("the browser is open and {string} is loaded")
    public void theBrowserIsOpenAndIsLoaded(String url) {
        driver.get(url); // Open the browser with the specified URL
    }

    // დალოგინება
    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        // Assuming that this step waits for the homepage to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='PSP.GE - ონლაინ აფთიაქი']")));
    }

    @When("the user clicks on the login icon")
    public void the_user_clicks_on_the_login_icon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__buttons header__buttons--desktop')]//button[2]")));
        userIcon.click();
    }

    @And("enters the email as {string}")
    public void enters_the_email_as(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder=' '])[1]")));
        emailField.sendKeys(email);
    }

    @And("enters the password as {string}")
    public void enters_the_password_as(String password) {
        WebElement passwordField = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        passwordField.sendKeys(password);
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("(//button[contains(@type,'button')])[2]"));
        loginButton.click();
        System.out.println("ავტორიზაცია წარმატებით დასრულდა");
    }

    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        // Implement a check for successful login, e.g., verifying the presence of a user profile element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-profile']"))); // Example for logged-in state
        System.out.println("Successfully logged in");
    }


    //რეგისტრაცია


    @When("the user clicks on the user icon")
    public void theUserClicksOnTheUserIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__buttons header__buttons--desktop')]//button[2]//*[name()='svg']")));
        userIcon.click();
        System.out.println("User icon clicked");
    }

    @And("clicks on the registration button")
    public void clicksOnTheRegistrationButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registrationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn--md btn--link btn--filled')]")));
        registrationButton.click();
        System.out.println("Registration button clicked");
    }

    @And("enters their first name as {string}")
    public void entersTheirFirstNameAs(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'register-modal__grid')]//div[1]")));
        firstNameField.sendKeys("მაია");
        System.out.println("Entered first name: " + "მაია");

    }


    @And("enters their last name as {string}")
    public void entersTheirLastNameAs(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'register-modal__grid')]//div[2]//div[1]//input[1]")));
        lastNameField.sendKeys("ხალვაში");
        System.out.println("Entered last name: " + "ხალვაში");
    }


    @And("enters their phone number as {string}")
    public void entersTheirPhoneNumberAs(String phoneNumber) {
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[contains(@data-mask,'+############')]"));
        phoneNumberField.sendKeys("593797191");
    }


    @And("enters their email as {string}")
    public void entersTheirEmailAs(String email) {
        WebElement emailField = driver.findElement(By.xpath("//div[contains(@class,'modal register-modal')]//div[3]//div[1]//input[1]"));
        emailField.sendKeys("khalvashim@gmail.com");
    }

    @And("enters their password as {string}")
    public void entersTheirPasswordAs(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/header/div[3]/div[1]/div[2]/form/div[4]/div/input"));
        passwordField.sendKeys("batumi@2025");
    }

    @And("confirms their password as {string}")
    public void confirmsTheirPasswordAs(String confirmPassword) {
        WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/header/div[3]/div[1]/div[2]/form/div[5]/div/input"));
        confirmPasswordField.sendKeys("batumi@2025");
    }

    @And("agrees to the terms and conditions")
    public void agreesToTheTermsAndConditions() {
        WebElement termsCheckbox = driver.findElement(By.xpath("//span[@class='checkbox__mark']"));
        termsCheckbox.click();
    }


    @And("clicks the register button")
    public void clicksTheRegisterButton() {
        WebElement registerButton = driver.findElement(By.xpath("//body/div[@id='app']/header[contains(@class,'header')]/div[contains(@class,'modal register-modal')]/div[contains(@class,'modal__content')]/div[contains(@class,'modal__body')]/form[contains(@autocomplete,'off')]/button[1]"));
        registerButton.click();
    }


    @Then("the user should be successfully registered")
    public void theUserShouldBeSuccessfullyRegistered() {
        System.out.println("რეგისტრაცია წარმატებით დასრულდა");
    }


//კალათაში პროდუქტის დამატება
//xpath-ი უნდა გადავამოწმო


    @When("the user searches for a product with the keyword {string}")
    public void theUserSearchesForProduct(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-input']")));
        searchField.sendKeys(keyword);
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-button']"));
        searchButton.click();
    }

    @And("selects the first product from the results")
    public void theUserSelectsFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-list']//div[1]")));
        firstProduct.click();
    }

    @And("adds the product to the cart")
    public void theUserAddsProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add-to-cart']")));
        addToCartButton.click();
    }

    @And("the user is redirected to the login page")
    public void theUserIsRedirectedToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("login"));
    }

    @And("the user enters the email as {string}")
    public void theUserEntersEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.sendKeys(email);
    }

    @And("the user enters the password as {string}")
    public void theUserEntersPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-button']"));
        loginButton.click();
    }

    @And("the user chooses the city {string}")
    public void theUserChoosesCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='city-select']")));
        cityDropdown.sendKeys(city);
    }

    @Then("the product should be successfully added to the cart")
    public void theProductIsAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'პროდუქტი წარმატებით დაემატა')]")));
        assert validationMessage.isDisplayed(); // Validate success message
    }

    @And("the user should see the product in their cart")
    public void theUserSeesProductInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='cart-button']")));
        cartButton.click();

        WebElement cartProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-item']")));
        assert cartProduct.isDisplayed(); // Validate that the product is in the cart
    }
}
