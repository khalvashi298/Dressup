////package driver.java;
////
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
////import io.github.bonigarcia.wdm.WebDriverManager;
////
////public class Driver {
////    private static WebDriver driver;
////
////    public static WebDriver getDriver() {
////        if (driver == null) {
////            WebDriverManager.chromedriver().setup();
////            driver = new ChromeDriver();
////            driver.manage().window().maximize();
////        }
////        return driver;
////    }
////
////    public static void quitDriver() {
////        if (driver != null) {
////            driver.quit();
////            driver = null;
////        }
////    }
////}
//package driver.java;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Driver {
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            driver = new ChromeDriver();
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}

package driver.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup(); // <-- ეს დაამატე აქ
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
//package driver.java;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Driver {
//
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // ქეშის გაწმენდა და ბრაუზერის დრაივერის დაყენება
//            WebDriverManager.chromedriver()
//                    .clearDriverCache()
//                    .clearResolutionCache()
//                    .setup();
//
//            driver = new ChromeDriver();
//            driver.manage().window().maximize(); // გახსნას სრულ ეკრანზე
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}

//package driver.java;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Driver {
//
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            // მიუთითე პირდაპირ ხელით დაყენებული chromedriver-ის გზა
//            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize(); // სრულ ეკრანზე გახსნა
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}
