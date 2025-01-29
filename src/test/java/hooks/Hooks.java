//package hooks;

////import ge.automation.driver.DriverManager;
////import ge.automation.utils.ConfigReader;
////import io.cucumber.java.After;
////import io.cucumber.java.Before;
////import org.openqa.selenium.WebDriver;
////
////import java.time.Duration;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import utils.ConfigReader;
//
//import java.sql.DriverManager;
//import java.time.Duration;
//
//public class Hooks {
//
//    WebDriver driver;
//
//    @Before
//    public void setup() {
//        driver = DriverManager.getDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.read("wait"))));
//    }
//
//    @After
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }
//}


//import driver.DriverManager;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import utils.ConfigReader;
//
//import java.time.Duration;
//
//public class Hooks {
//
//    WebDriver driver;
//
//    @Before
//    public void setup() {
//        driver = DriverManager.getDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.read("wait"))));
//    }
//
//    @After
//    public void tearDown() {
//        DriverManager.quitDriver();
//    }
//}
package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.time.Duration;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();  // ბრაუზერის გაშლა
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.get("wait"))));  // ლოდინის დრო
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();  // WebDriver-ის დახურვა
    }
}

 

