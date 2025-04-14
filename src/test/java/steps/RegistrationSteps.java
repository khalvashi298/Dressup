package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Logger;
import static driver.java.Driver.getDriver;

  public class RegistrationSteps {

    private static final Logger logger = Logger.getLogger(String.valueOf(RegistrationSteps.class));

    @Given("the browser is open and the  {string} website is loaded")
    public void theBrowserIsOpenAndTheWebsiteIsLoaded(String url) {

        getDriver().get(url);
    }

    @And("the user closes the pop-up window")
    public void theUserClosesThePopUpWindow() {

        closePopupIfVisible();
    }

    @When("the user clicks on the user icon")
    public void theUserClicksOnTheUserIcon() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[@class='title'][contains(text(),'ავტორიზაცია')])[1]")
        ));
        userIcon.click();
    }

    @When("the user closes the pop-up window again")
    public void theUserClosesThePopUpWindowAgain() {

        closePopupIfVisible();
    }

    @When("clicks on the registration button")
    public void clicksOnTheRegistrationButton() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By registerBtnLocator = By.xpath("(//a[@class='ml-1 newauth-link font-weight-bold d-block'][contains(text(),'რეგისტრაცია')])[1]");

        closePopupIfVisible(); // დავრწმუნდეთ, რომ popup არ ფარავს

        try {
            WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerBtnLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Registration button click intercepted. Retrying with JS click.");
            WebElement registerButton = driver.findElement(registerBtnLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);
        }
    }

    private void closePopupIfVisible() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By closeBtnLocator = By.xpath("//button[contains(@class, 'popup-close')]");

        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeBtnLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(closeBtnLocator));
            System.out.println("Popup closed successfully.");
        } catch (TimeoutException e) {
            System.out.println("Popup not present.");
        } catch (Exception e) {
            System.out.println("Error while closing popup: " + e.getMessage());
        }
    }
    @Then("the registration form should be visible")
    public void theRegistrationFormShouldBeVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("customer-form")
        ));
        assert form.isDisplayed();
    }

    @And("enters their email as {string}")
    public void entersTheirEmailAs(String email) {
        WebElement emailField = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@data-validate='isEmail'])[1]"))); // ✅ დახურულია )
        emailField.sendKeys(email);
    }

    @And("enters their first name as {string}")
    public void entersTheirFirstNameAs(String firstName) {
        WebElement firstNameField = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='მიუთითეთ თქვენი სახელი'])[1]")));
        firstNameField.sendKeys(firstName);
    }

    @And("enters their last name as {string}")
    public void entersTheirLastNameAs(String lastName) {
        WebElement lastNameField = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='მიუთითეთ თქვენი გვარი'])[1]")));
        lastNameField.sendKeys(lastName);
    }

    @And("enters their personal number as {string}")
    public void entersTheirPersonalNumberAs(String personalNumber) {
        WebElement personalNumberField = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='მიუთითეთ თქვვენი პირადი ნომერი'])[1]")));
        personalNumberField.sendKeys(personalNumber);
    }

    @And("enters their password as {string}")
    public void entersTheirPasswordAs(String password) {
        WebElement passwordField = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@title='მინიმუმ 5 სიმბოლო'])[1]")));
        passwordField.sendKeys(password);
    }


    @And("agrees to the terms and conditions")
    public void agreesToTheTermsAndConditions() {
        WebElement checkbox = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='ff_optin'])[1]"))); // შენ ჩასვი სწორი XPath

        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);

        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(checkbox))
                    .click();
        } catch (Exception e) {
            // fallback: პირდაპირ JavaScript-ით დაჭერა
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", checkbox);
        }
    }
        @And("clicks the register button")
        public void clicksTheRegisterButton () {
            WebElement registerButton = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']"))); // ან შესაბამისი XPath

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", registerButton);

            try {
                new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(registerButton))
                        .click();
            } catch (Exception e) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", registerButton);
            }
        }
    }


    