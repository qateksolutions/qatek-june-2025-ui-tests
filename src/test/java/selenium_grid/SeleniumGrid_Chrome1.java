package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Chrome1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Chrome1.class);

    @Test
    public void executeInAwsDocker() {
        ChromeOptions chromeOptions = new ChromeOptions();
        URL gridUrl = null;
        try {
            gridUrl = new URL("http://3.93.151.249:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new RemoteWebDriver(gridUrl, chromeOptions);
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        LOGGER.info("Title is: " + title);
        driver.quit();
    }
}
