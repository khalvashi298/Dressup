package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class PSPSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public PSPSteps() {
        // Constructor initialization
        this.driver = Hooks.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String searchQuery) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-bar']")));
        searchBar.sendKeys(searchQuery);

        System.out.println("Entered product in search bar: " + searchQuery);
    }

    @When("clicks the search button")
    public void clicksTheSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='search-button']")));
        searchButton.click();
        System.out.println("Search button clicked.");
    }

    @Then("the user should see the product in search results")
    public void theUserShouldSeeTheProductInSearchResults() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-name'][contains(text(), 'ვიტამინი C - Vitamin C ფორთოხლით 20 შუშხუნა ტაბლეტი')]")));
        assertTrue(product.isDisplayed(), "Product is not displayed in the search results!");
        System.out.println("Product is visible in search results.");
    }

//დ

    @Given("the browser is launched and {string} login page is opened")
    public void theBrowserIsLaunchedAndLoginPageIsOpened(String arg0) {
        driver.get("https://psp.ge");  // PSP-ს მთავარი გვერდი
        Assert.assertTrue(driver.getTitle().contains("PSP"));
    }

    @When("the user adds the {string} to the cart")
    public void theUserAddsTheToTheCart(String arg0) {
        WebElement product = driver.findElement(By.xpath("//div[@class='product-name'][contains(text(), 'ვიტამინი C - Vitamin C ფორთოხლით 20 შუშხუნა ტაბლეტი')]"));
        product.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-button']"));
        addToCartButton.click();

    }

    @Then("the cart should contain the {string}")
    public void theCartShouldContainThe(String arg0) {
            WebElement cartIcon = driver.findElement(By.xpath("//a[@id='cart']"));
            cartIcon.click();  // კალათაში გადასვლა

            WebElement cartProduct = driver.findElement(By.xpath("//div[@class='cart-product-name'][contains(text(), 'ვიტამინი C - Vitamin C ფორთოხლით 20 შუშხუნა ტაბლეტი')]"));
            assertTrue(cartIcon.isDisplayed(), "Product is not present in the cart!");
            System.out.println("Verified: Product is in the cart.");
        }
    }
