package hooks;

import driver.java.Driver;
import io.cucumber.java.*;
import static driver.java.Driver.getDriver;
import static driver.java.Driver.quitDriver;


public class Hooks {

    @Before
    public static void setUp() {
        getDriver();
    }


    @After
    public static void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            ScreenshotUtil.captureScreenshot(getDriver(),scenario.getName().replaceAll(" ","_"));
        }
        Driver.getDriver().manage().deleteAllCookies();


        if (getDriver() != null) {
            quitDriver();
        }
    }
}
