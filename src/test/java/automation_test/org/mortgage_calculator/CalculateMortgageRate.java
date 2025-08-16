package automation_test.org.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;

public class CalculateMortgageRate {
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @Test
    public void calculateMonthlyPayment() {
        String[] date = DateUtils.returnNextMonth();
        String month = date[0];
        String year = date[1];
        new Home(driver)
                .validatePageTitle("Mortgage Calculator")
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentInDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectMonth(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePMI("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMonthlyHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefinanceOption("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("$1,611.85");
    }

    @AfterMethod
    public void browserCleanup() {
        ActOn.browser(driver).closeBrowser();
    }
}
