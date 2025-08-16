package utilities_qatek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    // Do not allow to initialize this class from outside
    private DriverFactory() {
        // Do Nothing -- Empty constructor
    }

    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    // Thread local driver object for WebDriver
    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    });

    // Call this method to get the driver object and launch the browser
    public WebDriver getDriver() {
        return driver.get();
    }

    // Quits the driver and closes the browser
    public void removeDriver() {
        getDriver().quit();
        driver.remove();
    }

}
