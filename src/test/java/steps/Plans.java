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
    public void navigateToPlansPage() {
        clickOnElement(ProfilePage.PLANS_LINK);
    }
    @Then("plans page should be displayed")
    public void plansPageDisplayed() {
        Assert.assertTrue("Title should be displayed", isElementDisplayed(ProfilePage.PLANS_TITLE));
    }
    @And("there should be 4 rows of data")
    public void validateNumRows() {
        List<WebElement> rows = getElements(ProfilePage.PLANS_ROWS);
        int expectedNumRows = 4;
        Assert.assertEquals("Number of rows should be 4", expectedNumRows, rows.size());
    }
    @Then("validate the Create Date is today's date in EST Time Zone")
    public void validateCreateDateIsTodayInEST() {
        String displayedCreateDate = getElementText(ProfilePage.DATE_CREATED);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        String actualDate = LocalDate.now(ZoneId.of("America/New_York")).format(dateFormatter);
        Assert.assertEquals("Create Date should match today's date", actualDate, displayedCreateDate);
    }
    @And("validate the Expire Date is one day after today's date in EST Time Zone")
    public void validateExpireDateIsOneDayAfterInEST() {
        String displayedExpireDate = getElementText(ProfilePage.DATE_EXPIRED);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        String actualExpireDate = LocalDate.now(ZoneId.of("America/New_York")).plusDays(1).format(dateFormatter);
        Assert.assertEquals("Expire Date should be one day after today's date", actualExpireDate, displayedExpireDate);
    }
}
