package utility;
import base.BaseSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);
    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    }
    private WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickOnElement(By locator) {
        LOGGER.info("Clicking on Element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void sendText(By locator, String value) {
        LOGGER.info("Clearing and sending text '{}' to locator {}", value, locator);
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }
    public String getElementText(By locator) {
        LOGGER.info("Getting text from Element {}", locator);
        return waitForVisibility(locator).getText();
    }
    public boolean isElementEnabled(By locator) {
        LOGGER.info("Checking if element is enabled: {}", locator);
        return waitForVisibility(locator).isEnabled();
    }
    public boolean isElementDisplayed(By locator) {
        LOGGER.info("Checking if element is displayed: {}", locator);
        return waitForVisibility(locator).isDisplayed();
    }
    public byte[] takeScreenshot() {
        LOGGER.info("Taking screenshot");
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
    public List<WebElement> getElements(By locator) {
        LOGGER.info("Getting all elements for locator {}", locator);
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public void selectDropdownByVisibleText(By locator, String visibleText) {
        LOGGER.info("Selecting dropdown option '{}' from locator {}", visibleText, locator);
        WebElement dropdownElement = waitForVisibility(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
    public void selectDropdownByValue(By locator, String value) {
        LOGGER.info("Selecting dropdown option with value '{}' from locator {}", value, locator);
        WebElement dropdownElement = waitForVisibility(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
    public void setDate(By locator, String date) {
        LOGGER.info("Setting date '{}' to locator {}", date, locator);
        WebElement dateInput = waitForVisibility(locator);
        dateInput.clear();
        dateInput.sendKeys(date);
    }
    public String convertDateToISO(String date) {
        LOGGER.info("Converting date '{}' from 'MM/dd/yyyy' to 'yyyy-MM-dd'", date);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, inputFormatter);
        return localDate.format(outputFormatter);
    }
}
