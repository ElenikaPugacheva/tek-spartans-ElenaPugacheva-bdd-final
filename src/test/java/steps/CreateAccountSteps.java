package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CreatePrimaryAccountHolderPage;
import pages.HomePage;
import pages.ProfilePage;
import pages.SignInPage;
import utility.RandomEmail;
import utility.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {
    private String firstName;
    private String lastName;
    private String randomEmail;
    @Then("the Create Primary Account button should exist and click on it")
    public void primaryAccountBTN_ShouldPresent() {
        Assert.assertTrue("The 'Create Primary Account' button is not enabled!", isElementEnabled(HomePage.CREATE_PRIMARY_ACCOUNT));
        clickOnElement(HomePage.CREATE_PRIMARY_ACCOUNT);
    }
    @Then("user should be navigated to the Create Account form page")
    public void navigateCreateAccountFormPage() {
        Assert.assertTrue("The 'Create Primary Account Holder' is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.CREATE_PRIMARY_ACCOUNT_HOLDER_TITLE));
    }
    @Then("user enter {string} in {string} field")
    public void userFillAllField(String value, String fieldName) {
        if (fieldName.equals("Email Address")) {
            sendText(CreatePrimaryAccountHolderPage.EMAIL_INPUT, value);
        } else if (fieldName.equals("First Name")) {firstName = value;
            sendText(CreatePrimaryAccountHolderPage.FIRST_NAME_INPUT, value);
        } else if (fieldName.equals("Gender")) {
            selectDropdownByValue(CreatePrimaryAccountHolderPage.GENDER, value);
        } else if (fieldName.equals("Employment Status")) {
            sendText(CreatePrimaryAccountHolderPage.EMPLOYMENT_STATUS_INPUT, value);
        } else if (fieldName.equals("Title/Prefix")) {
            selectDropdownByVisibleText(CreatePrimaryAccountHolderPage.TITLE_PREFIX, value);
        } else if (fieldName.equals("Last Name")) {lastName = value;
            sendText(CreatePrimaryAccountHolderPage.LAST_NAME_INPUT, value);
        } else if (fieldName.equals("Marital Status")) {
            selectDropdownByVisibleText(CreatePrimaryAccountHolderPage.MATERIAL_STATUS, value);
        } else if (fieldName.equals("Date Of Birth")) {
            setDate(CreatePrimaryAccountHolderPage.DOB, value);
        }
    }
    @Then("user enters random email into {string} field")
    public void randomEmailForUser(String fieldName) {
        String randomEmail = RandomEmail.EmailGenerator("eli");
        sendText(CreatePrimaryAccountHolderPage.EMAIL_INPUT, randomEmail);
    }
    @When("user should be navigated on Sign up your account page")
    public void navigateOnSignUpAccountPage() {
        Assert.assertTrue("The 'Sign up your account' page is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.SIGN_UP_YOUR_ACCOUNT_TITLE));
    }
    @Then("user navigate to page email address and full name shows as expected")
    public void emailAddressShowsAsExpected() {
        Assert.assertTrue("The full name page is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.EXPECTED_FULL_NAME));
        Assert.assertTrue("The email page is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.EXPECTED_EMAIL));
    }
    @Then("user should see an error message")
    public void validateErrorMessage() {
        Assert.assertTrue("The error message is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.ERROR_MSG));
    }
    @Then("user enter {string} in the Create Account username field")
    public void enterUsernameCreateAccount(String value) {
        sendText(CreatePrimaryAccountHolderPage.USERNAME_INPUT, value);
    }
    @Then("user enter {string} in the Create Account password field")
    public void enterPasswordCreateAccount(String value) {
        sendText(CreatePrimaryAccountHolderPage.PASSWORD_INPUT, value);
    }
    @Then("user enter {string} in the Create Account confirm password field")
    public void confirmPasswordCreateAccount(String value) {
        sendText(CreatePrimaryAccountHolderPage.CONFIRM_PASSWORD_INPUT, value);
    }
    @Then("validate Sign in to your Account page")
    public void validateSignInToYourAccount() {
        Assert.assertTrue("The 'Sign in to your Account' is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.SIGN_IN_TO_YOUR_ACCOUNT));
    }
    @Then("user should see an error message 'you must be 18 years or older to create account'")
    public void errorMessageAge() {
        Assert.assertTrue("The message 'you must be 18 years or older to create account' is not displayed", isElementDisplayed(CreatePrimaryAccountHolderPage.ERROR_MSG));
    }
    @Then("user enter {string} in the Sign In username field")
    public void enterUsernameSignIn(String value) {
        sendText(SignInPage.USERNAME, value);
    }
    @Then("user enter {string} in the Sign In password field")
    public void enterPasswordSignIn(String value) {
        sendText(SignInPage.PASSWORD, value);
    }
    @Then("click on profile button")
    public void clickOnProfileBTN() {
        clickOnElement(ProfilePage.PROFILE_BTN);
    }
    @Then("validate FULL NAME displayed at profile section")
    public void fullNameDisplayed() {
        Assert.assertTrue("Full name is not displayed", isElementDisplayed(ProfilePage.PR0FILE_FULL_NAME));
        String displayedFullName = getElementText(ProfilePage.PR0FILE_FULL_NAME);
        String expectedFullName = firstName + " " + lastName;
        Assert.assertEquals("Full name does not match", expectedFullName, displayedFullName);
    }
}
