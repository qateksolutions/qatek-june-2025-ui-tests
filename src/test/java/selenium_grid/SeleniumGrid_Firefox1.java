package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Firefox1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Firefox1.class);

    @Test
    public void executeInAwsDocker() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        URL gridUrl = null;
        try {
            gridUrl = new URL("http://3.93.151.249:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = new RemoteWebDriver(gridUrl, firefoxOptions);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        LOGGER.info("Title is: " + title);
        driver.quit();
    }
}
