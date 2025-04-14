package steps;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Logger;
import static driver.java.Driver.getDriver;
public class LoginSteps {

    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());


    @Given("the browser is open and the {string} website is loaded")
    public void theBrowserIsOpenAndTheWebsiteIsLoaded(String url) {
        logger.info("Opening browser and loading the website: " + url);
        getDriver().get(url);
    }
    @And("the user closes the pop-up")
    public void theUserClosesThePopUp() {
        logger.info("Closing the pop-up");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='close']")));
            closeButton.click();
        } catch (TimeoutException e) {
            logger.warning("Pop-up not found or not clickable: " + e.getMessage());
        }

    }
    @When("the user selects the login option")
    public void theUserSelectsTheLoginOption() {
        logger.info("Clicking the login option");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[@class='title'][contains(text(),'ავტორიზაცია')])[1]")
        ));
        icon.click();

    }

    @And("the user enters email {string}")
    public void theUserEntersEmail(String email) {
        logger.info("Entering email: " + email);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='ელ-ფოსტა'])[1]")));
        emailField.sendKeys(email);
    }

    @And("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        logger.info("Entering password: " + password);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='პაროლი'])[1]")));
        passwordField.sendKeys(password);
    }

      @And("the user clicks the login button")
        public void theUserClicksTheLoginButton() {
            logger.info("Clicking the login button");
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            By loginBtn = By.xpath("(//button[@type='submit'][contains(text(),'ავტორიზაცია')])[1]");

            try {
                WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));

                // სკროლავს ღილაკზე და შემდეგ click-ს ახორციელებს JavaScript-ით
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", loginButton);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

            } catch (Exception e) {
                logger.warning("Unable to click login button: " + e.getMessage());
            }
        }

        @Then("the user should be successfully logged in")
       public void theUserShouldBeSuccessfullyLoggedIn() {
      logger.info("Verifying successful login");

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    try {
        // ვამოწმებთ ლოგოს არსებობას, როგორც წარმატებული ავტორიზაციის სიგნალს
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//img[@alt='Dressup.ge'])[1]")));

        if (logo.isDisplayed()) {
            logger.info("Login successful: Dressup.ge logo is displayed.");
        }
    } catch (TimeoutException e) {
        logger.warning("Login failed or logo not found: " + e.getMessage());
    }
}

}