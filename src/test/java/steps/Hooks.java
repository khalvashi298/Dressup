
package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    public static void setup() {
        // მიუთითეთ chromedriver-ის გზა
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32 (1)\\chromedriver.exe");

        // დააინიციალეთ ბრაუზერი
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
