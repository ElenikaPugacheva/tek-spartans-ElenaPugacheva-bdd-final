package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProfilePage;
import utility.SeleniumUtility;
import java.util.Map;
public class UserProfileSteps extends SeleniumUtility{
    @When("user click on Profile button")
    public void clickOnProfileBTN(){
        clickOnElement(ProfilePage.PROFILE_BTN);
    }
    @Then("validate information in Profile Side Drawer is should match")
    public void validationProfileInfo(DataTable dataTable) {
        Assert.assertTrue("Title is not displayed", isElementDisplayed(ProfilePage.PROFILE_SIDE_TITLE));
        Map<String, String> expectedData = dataTable.asMap(String.class, String.class);
        // for User Type
        String actualUserType = getElementText(ProfilePage.PROFILE_USER_TYPE).trim();
        String expectedUserType = expectedData.get("User Type");
        Assert.assertEquals("User Type not matched", expectedUserType, actualUserType);
        // for fullName
        String actualFullName = getElementText(ProfilePage.PR0FILE_FULL_NAME).trim();
        String expectedFullName = expectedData.get("Full Name");
        Assert.assertEquals("Full Name not matched", expectedFullName, actualFullName);
        // for Username
        String actualUserName = getElementText(ProfilePage.PR0FILE_USERNAME).trim();
        String expectedUserName = expectedData.get("UserName");
        Assert.assertEquals("Username not matched", expectedUserName, actualUserName);
        // for Authorities
        String actualAuthorities = getElementText(ProfilePage.PROFILE_USER_AUTHORITIES).trim();
        String expectedAuthorities = expectedData.get("Authorities");
        Assert.assertEquals("Authorities not matched", expectedAuthorities, actualAuthorities);
    }
}
