package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home extends NavigationBar {
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By DownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanPaymentInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HoiInputField = By.id("hoi");
    private final By HoaInputField = By.id("hoa");
    private final By LoanTypeDropdown = By.name("param[milserve]");
    private final By BuyOrRefiDropdown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");
    private final By TotalMonthlyPayment = By.xpath("//div[@class='repayment-block']/div/div[contains(.,'Total Monthly Payment')]//following-sibling::h3");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver) {
        super(driver);
    }

    public Home validatePageTitle(String expectedTitle) {
        LOGGER.debug("Validating the Page title is: " + expectedTitle);
        String actualTitle = ActOn.browser(driver).captureTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        return this;
    }

    public Home typeHomePrice(String value) {
        LOGGER.debug("Enter Home Value: " + value);
        ActOn.element(driver, HomeValueInputField).setValue(value);
        return this;
    }

    public Home typeDownPayment(String value) {
        LOGGER.debug("Enter the down payment: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public Home clickDownPaymentInDollar() {
        LOGGER.debug("Click on the radio button $");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public Home typeLoanAmount(String value) {
        LOGGER.debug("Enter the loan amount: " + value);
        ActOn.element(driver, LoanPaymentInputField).setValue(value);
        return this;
    }

    public Home typeInterestRate(String value) {
        LOGGER.debug("Enter interest rate: " + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public Home typeLoanTermYears(String value) {
        LOGGER.debug("Enter loan term: " + value);
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }

    public Home selectMonth(String month) {
        LOGGER.debug("Select the start date month: " + month);
        ActOn.element(driver, StartMonthDropDown).selectValue(month);
        return this;
    }

    public Home typeYear(String year) {
        LOGGER.debug("Enter loan start year: " + year);
        ActOn.element(driver, StartYearInputField).setValue(year);
        return this;
    }

    public Home typePropertyTax(String value) {
        LOGGER.debug("Enter property tax: " + value);
        ActOn.element(driver, PropertyTaxInputField).setValue(value);
        return this;
    }

    public Home typePMI(String value) {
        LOGGER.debug("Enter PMI: " + value);
        ActOn.element(driver, PmiInputField).setValue(value);
        return this;
    }

    public Home typeHomeOwnerInsurance(String value) {
        LOGGER.debug("Enter the home owner insurance: " + value);
        ActOn.element(driver, HoiInputField).setValue(value);
        return this;
    }

    public Home typeMonthlyHoa(String value) {
        LOGGER.debug("Enter the monthly hoa: " + value);
        ActOn.element(driver, HoaInputField).setValue(value);
        return this;
    }

    public Home selectLoanType(String value) {
        LOGGER.debug("Select the loan type: " + value);
        ActOn.element(driver, LoanTypeDropdown).selectValue(value);
        return this;
    }

    public Home selectBuyOrRefinanceOption(String value) {
        LOGGER.debug("Select option: " + value);
        ActOn.element(driver, BuyOrRefiDropdown).selectValue(value);
        return this;
    }

    public Home clickOnCalculateButton() {
        LOGGER.debug("Click on the calculate button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String expectedMonthlyPayment) {
        LOGGER.debug("Validating total monthly payment is: " + expectedMonthlyPayment);
        ActOn.wait(driver, TotalMonthlyPayment).waitForElementToBeVisible();
        String actualMonthlyPayment = ActOn.element(driver, TotalMonthlyPayment).getTextValue();
        LOGGER.debug("Actual Monthly Payment: " + actualMonthlyPayment);
        Assert.assertEquals(actualMonthlyPayment, expectedMonthlyPayment, "Total Monthly payment is failed to match");
        return this;
    }

}
