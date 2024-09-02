package pages;
import org.openqa.selenium.By;
import utility.SeleniumUtility;

public class HomePage extends SeleniumUtility {
    public static final By TEK_INSURANCE_APP = By.cssSelector("h2.chakra-heading.css-1at26de");
    public static final By CREATE_PRIMARY_ACCOUNT = By.cssSelector("a.chakra-button.css-1jp0m7c[href=\"/add-primary-account\"]");
}
