package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import utility.SeleniumUtility;

public class HomePageValidationTest extends SeleniumUtility {
    @Given("user navigates to the home page and validate the TEK Insurance App title")
    public void user_navigates_to_the_home_page_and_validate_the_title() {
        String expectedTitle = "Tek Insurance UI";
        String actualTitle = getPageTitle();
        Assert.assertEquals("The page title does not match!", expectedTitle, actualTitle);
        Assert.assertTrue("The TEK Insurance App title is not displayed!", isElementDisplayed(HomePage.TEK_INSURANCE_APP));
    }
    @Then("the Create Primary Account button should exist")
    public void the_register_here_button_should_exist() {
        Assert.assertTrue("The 'Create Primary Account' button is not enabled!", isElementEnabled(HomePage.CREATE_PRIMARY_ACCOUNT));
    }
}
