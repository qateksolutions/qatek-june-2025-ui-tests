package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Edge1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Edge1.class);

    @Test
    public void executeInAwsDocker() {
        EdgeOptions edgeOptions = new EdgeOptions();
        URL gridUrl = null;
        try {
            gridUrl = new URL("http://3.93.151.249:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = new RemoteWebDriver(gridUrl, edgeOptions);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        LOGGER.info("Title is: " + title);
        driver.quit();
    }
}
