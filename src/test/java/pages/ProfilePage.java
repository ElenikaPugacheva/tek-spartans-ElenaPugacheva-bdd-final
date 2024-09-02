package pages;
import org.openqa.selenium.By;
import utility.SeleniumUtility;

public class ProfilePage extends SeleniumUtility {
    public static final By PROFILE_BTN = By.xpath("//button[@aria-label='profile']");
    public static final By PROFILE_SIDE_TITLE = By.xpath("//header[text()='Profile']");
    public static final By PR0FILE_FULL_NAME = By.xpath("//p[text() = 'FULL NAME']/following-sibling::p");
    public static final By PROFILE_USER_TYPE = By.xpath("//p[text() = 'USER TYPE']/following-sibling::p");
    public static final By PR0FILE_USERNAME = By.xpath("//div[contains(@class, 'chakra-stack')]//p[text()='USERNAME']/following-sibling::p");
    public static final By PROFILE_USER_AUTHORITIES = By.xpath("//p[text() = 'AUTHORITIES']/following-sibling::ul");
    //Plans
    public static final By PLANS_LINK = By.xpath("//a[@href='/csr/plans' and contains(text(), 'Plans')]");
    public static final By PLANS_TITLE = By.xpath("//h2[text()=\"Today's Plans Price\"]");
    public static final By PLANS_ROWS = By.xpath("//table[@class='chakra-table css-5605sr']/tbody/tr");
    //Date
    public static final By DATE_CREATED = By.xpath("//tbody[@class='css-0']//tr[@class='css-0']//td[4]");
    public static final By DATE_EXPIRED = By.xpath("//tbody[@class='css-0']//tr[@class='css-0']//td[5]");


}
