package pages;
import org.openqa.selenium.By;
import utility.SeleniumUtility;
public class SignInPage extends SeleniumUtility {
    // Sign in to Account Page

    public static final By LOGIN_BTN = By.xpath("//a[@href='/login']");
    public static final By USERNAME = By.name("username");
    public static final By PASSWORD = By.name("password");
    public static final By SIGN_IN_BTN = By.xpath("//button[@type='submit' and text()='Sign In']");
    public static final By CUSTOMER_SERVICE_PORTAL = By.xpath("//h2[text()='Customer Service Portal']");

    public static final By ERROR_USERNAME_NF = By.xpath("//div[@data-status='error' and contains(text(), 'not found')]");
    public static final By ERROR_PASSWORD_NM = By.xpath("//div[contains(., 'not matched')]");


}
