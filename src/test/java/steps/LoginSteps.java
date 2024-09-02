package steps;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CreatePrimaryAccountHolderPage;
import pages.SignInPage;
import utility.SeleniumUtility;
public class LoginSteps extends SeleniumUtility {
    @Then("user click on Login button")
    public void clickLogin(){
        clickOnElement(SignInPage.LOGIN_BTN);
    }
    @Then("user enter username {string} and {string} as password")
    public void userLoginWithUsernameAndAsPassword(String userName, String password) {
        sendText(CreatePrimaryAccountHolderPage.USERNAME_INPUT,userName);
        sendText(CreatePrimaryAccountHolderPage.PASSWORD_INPUT, password);
        clickOnElement(SignInPage.SIGN_IN_BTN);
    }
    @Then("user navigated to {string}")
            public void validateUserIsNavigatedTo(String expectedResult) {
        String actualResult = getElementText(SignInPage.CUSTOMER_SERVICE_PORTAL);
        Assert.assertEquals("Title should matched:" , expectedResult,actualResult);
    }
    @Then("user should be navigated to the {string}")
    public void customerServicePortal(){
        Assert.assertTrue("The title not found",isElementDisplayed(SignInPage.CUSTOMER_SERVICE_PORTAL));
    }
    @Then("user should see an error {string}")
    public void errorMSG(String expectedResult){
        String actualResult = getElementText(CreatePrimaryAccountHolderPage.ERROR_MSG);
        actualResult = actualResult.replace("ERROR", "").trim();
        Assert.assertEquals("Both message should be the same: ", expectedResult, actualResult);
    }
}