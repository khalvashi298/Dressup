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


public class RegistrationSteps {
    private static final Logger logger = Logger.getLogger(String.valueOf(RegistrationSteps.class));
//    private Instant wait;


    @Given("the browser is open and the PSP website is loaded")
    public void the_browser_is_open_and_the_psp_website_is_loaded() {
        // გახსენით გვერდი
        getDriver().get("https://psp.ge/");
    }

//  რეგისტრაცია


    @When("the user clicks on the user icon")
    public void theUserClicksOnUserIcon() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__buttons header__buttons--desktop')]//button[2]//*[name()='svg']")));
        userIcon.click();


    }

    //
    @When("clicks on the registration button")
    public void clicksOnTheRegistrationButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn--md btn--link btn--filled')]")));
        registerButton.click();
    }

    @And("enters their first name as {string}")
    public void entersTheirFirstNameAs(String firstName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'register-modal__grid')]//div[1]//div[1]//input[1]")));
        firstNameField.sendKeys(firstName);
        System.out.println("Entered first name: " + firstName);
    }

    @And("enters their last name as {string}")
    public void entersTheirLastNameAs(String lastName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'register-modal__grid')]//div[2]//div[1]//input[1]")));
        lastNameField.sendKeys(lastName);
        System.out.println("Entered last name: " + lastName);
    }

    @And("enters their phone number as {string}")
    public void entersTheirPhoneNumberAs(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@data-mask,'+############')]")));
        phoneField.sendKeys(phoneNumber);
        System.out.println("Entered phone number: " + phoneNumber);
    }

    @And("enters their email as {string}")
    public void entersTheirEmailAs(String email) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'modal register-modal')]//div[3]//div[1]//input[1]")));
        emailField.sendKeys(email);
        System.out.println("Entered email: " + email);
    }

    @And("enters their password as {string}")
    public void entersTheirPasswordAs(String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@placeholder,'')])[7]")));
        passwordField.sendKeys(password);
        System.out.println("Entered password: " + password);
    }

    @And("confirms their password as {string}")
    public void confirmsTheirPasswordAs(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@placeholder,'')])[7]")));
        confirmPasswordField.sendKeys(confirmPassword);
        System.out.println("Confirmed password: " + confirmPassword);
    }

    @When("agrees to the terms and conditions")
    public void agreesToTheTermsAndConditions() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='checkbox__mark']")));
        termsCheckbox.click();
        System.out.println("Agreed to the terms and conditions");

    }

    @When("clicks the register button")
    public void clicksTheRegisterButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='checkbox__mark']")));
        termsCheckbox.click();
        System.out.println("Agreed to the terms and conditions");
    }


}
