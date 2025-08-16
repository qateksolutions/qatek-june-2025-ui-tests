package automation_test.com.php_travel;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities_qatek.ScreenCapture;


public class PhpTravel {
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://phptravels.com/demo");
    }

    @Test
    public void verifyHomePageTitle() {
        String expectedTitle = "Book Your Free Demo Now - Phptravels";
        String actualTitle = ActOn.browser(driver).captureTitle();
        System.out.println("Actual Title is: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void browserCleanup(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenCapture.getScreenShot(driver);
        }
        driver.quit();
    }
}
