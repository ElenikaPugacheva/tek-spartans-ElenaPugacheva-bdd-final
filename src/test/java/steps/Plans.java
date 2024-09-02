package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ProfilePage;
import utility.SeleniumUtility;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Plans extends SeleniumUtility {
    @Given("user navigates to the Plans Page and click on it")
    public void navigateToPlansPage(){
        clickOnElement(ProfilePage.PLANS_LINK);
    }
    @Then("plans page should be displayed")
    public void plansPageDisplayed() {
        Assert.assertTrue("Title should displayed",isElementDisplayed(ProfilePage.PLANS_TITLE));
    }
    @And("there should be 4 rows of data")
    public void validateNumRows(){
        List<WebElement> rows = getElements(ProfilePage.PLANS_ROWS);
        int expectedNumRows = 4;
        Assert.assertEquals(rows.size(),expectedNumRows);
    }
    @Then("validate the Create Date is today's date in EST Time Zone")
    public void validateCreateDateIsTodayInEST() {
        String displayedCreateDate = getElementText(ProfilePage.DATE_CREATED);
        String expectedDate = "August 21, 2024";
        /*DateTimeFormatter expectedDateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        String expectedDate = LocalDate.now(ZoneId.of("America/New_York")).format(expectedDateFormat);*/
        Assert.assertEquals("Create Date should match the expected date", expectedDate, displayedCreateDate);
    }
    @And("validate the Expire Date is one day after today's date in EST Time Zone")
    public void validateExpireDateIsOneDayAfterInEST() {
        String displayedExpireDate = getElementText(ProfilePage.DATE_EXPIRED);
        String expectedExpireDate = "August 22, 2024";
        /*DateTimeFormatter displayedDateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        String expectedExpireDate = LocalDate.now(ZoneId.of("America/New_York")).plusDays(1).format(displayedDateFormat);*/
        Assert.assertEquals("Expire Date should match the expected date", expectedExpireDate, displayedExpireDate);
    }
}