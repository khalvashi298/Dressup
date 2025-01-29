//package driver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//   public class DriverManager {
//
//    private static WebDriver driver;
//
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
//        return driver;
//    }
//
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    // WebDriver-ის შექმნა
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();  // მართავს ChromeDriver-ს ვერსიას
            driver = new ChromeDriver();  // შექმნის ChromeDriver-ს ინსტანციას
        }
        return driver;
    }

    // WebDriver-ის დახურვა
    public static WebDriver quitDriver() {
        if (driver != null) {
            driver.quit();  // დახურავს ბრაუზერს
            driver = null;  // დაასუფთავებს WebDriver-დან
            System.setProperty("web driver.chrome.driver", "D:/path/to/chromedriver.exe");
            WebDriverManager.chromedriver().setup(); // მართავს ChromeDriver-ს ვერსიას
            driver = new ChromeDriver(); // ქმნის ChromeDriver-ს ინსტანციას
        }
        return driver;
    }
}






