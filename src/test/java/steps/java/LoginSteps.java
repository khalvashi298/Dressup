package steps.java;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static driver.java.Driver.getDriver;

public class LoginSteps {
    private static final Logger logger = Logger.getLogger(String.valueOf(RegistrationSteps.class));


    @Given("the browser is open and {string} is loaded")
    public void theBrowserIsOpenAndIsLoaded(String arg0) {
        getDriver().get("https://psp.ge/");
    }

    @When("the user clicks on the login icon")
    public void theUserClicksOnTheLoginIcon() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement loginIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__buttons header__buttons--desktop')]//button[2]")));
        loginIcon.click();
        logger.info("Login icon clicked");
    }


    @And("enters the email as {string}")
    public void enters_the_email_as(String email) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder=' '])[1]")));
        emailField.sendKeys(email);
        logger.info("Entered email: " + email);
    }

    @And("enters the password as {string}")
    public void enters_the_password_as(String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='password'])[1]")));
        passwordField.sendKeys(password);
        logger.info("Entered password: " + password);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@type,'button')])[2]")));
        loginButton.click();
        logger.info("Login button clicked");
    }


    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement userProfileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='container header__inner'])[1]")));

        logger.info("User is successfully logged in");
    }

}

