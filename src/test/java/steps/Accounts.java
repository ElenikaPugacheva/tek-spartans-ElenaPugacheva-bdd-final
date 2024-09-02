package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AccountsPage;
import utility.SeleniumUtility;
import java.util.List;

public class Accounts extends SeleniumUtility {
    @Given("user navigates to the Accounts Page and click on it")
    public void clickOnAccountLink(){
    clickOnElement(AccountsPage.Accounts_Link);
    }
    @Then("user should see 5 rows per page by default")
    public void userShouldValidateAccounts(){
        List<WebElement> rows = getElements(AccountsPage.ACCOUNTS_ROW);
        int expectedRowCount = 5;
        Assert.assertEquals("The default number of rows per page should be 5", expectedRowCount, rows.size());
    }
    @Then("click on drop down option Show {int} to {int}")
    public void changeShowPerPage(int from, int to) {
        selectDropdownByVisibleText(AccountsPage.DRP_DOWN, "Show " + to);
    }
    @Then("user should see {int} rows per page")
    public void validateRowsPerPage(int expectedRowCount) {
        List<WebElement> rows = getElements(AccountsPage.ACCOUNTS_ROW);
        Assert.assertEquals("The number of rows per page should be " + expectedRowCount, expectedRowCount, rows.size());
    }
}
