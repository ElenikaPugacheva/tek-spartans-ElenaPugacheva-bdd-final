package pages;
import org.openqa.selenium.By;
import utility.SeleniumUtility;

public class CreatePrimaryAccountHolderPage extends SeleniumUtility {
    public static final By CREATE_PRIMARY_ACCOUNT_HOLDER_TITLE = By.xpath("//h2[text()='Create Primary Account Holder']");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By FIRST_NAME_INPUT = By.id("firstName");
    public static final By LAST_NAME_INPUT = By.id("lastName");
    public static final By TITLE_PREFIX = By.xpath("//select[@id='title']");
    public static final By GENDER = By.xpath("//select[@id='gender']");
    public static final By EMPLOYMENT_STATUS_INPUT = By.id("employmentStatus");
    public static final By MATERIAL_STATUS = By.xpath("//select[@id='maritalStatus']");
    public static final By DOB = By.xpath("//input[@id='dateOfBirth']");
    public static final By SIGN_UP_YOUR_ACCOUNT_TITLE = By.xpath("//h2[text()='Sign up your account']");
    public static final By EXPECTED_FULL_NAME = By.xpath("//h2[contains(@class, 'chakra-heading') and contains(@class, 'css-18j379d')]");
    public static final By EXPECTED_EMAIL = By.xpath("//h2[contains(@class, 'chakra-heading') and contains(@class, 'css-18j379d')]");
    public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By CONFIRM_PASSWORD_INPUT = By.xpath("//input[@id='confirm']");
    public static final By SIGN_IN_TO_YOUR_ACCOUNT = By.xpath("//h2[text()='Sign in to your Account']");
    public static final By ERROR_MSG = By.className("chakra-alert");
}