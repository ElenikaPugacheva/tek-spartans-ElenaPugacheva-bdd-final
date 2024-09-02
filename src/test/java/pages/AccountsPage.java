package pages;
import org.openqa.selenium.By;
import utility.SeleniumUtility;
public class AccountsPage extends SeleniumUtility {
    public static final By Accounts_Link = By.xpath("//a[text()='Accounts']");
    public static final By ACCOUNTS_ROW = By.xpath("//tbody[@class='css-0']/tr[@class='css-0']");
    public static final By DRP_DOWN = By.xpath("//select[contains(@class, 'chakra-select') and contains(@class, 'css-')]");
}
