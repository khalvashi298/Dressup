//package steps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import java.util.logging.Logger;
//
//import static driver.java.Driver.getDriver;
//
//public class SearchSteps {
//    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());
//    @Given("the browser is open and the {string} website is loaded")
//    public void theBrowserIsOpenAndTheWebsiteIsLoaded(String url) {
//        logger.info("Opening browser and loading the website: " + url);
//        getDriver().get(url);
//    }
//
//    @Given("the user is on the homepage")
//    public void theUserIsOnTheHomepage() {
//
//    }
//
//    @When("the user searches for {string}")
//    public void theUserSearchesFor(String arg0) {
//
//    }
//
//    @Then("search results should be displayed")
//    public void searchResultsShouldBeDisplayed() {
//    }
//}
//