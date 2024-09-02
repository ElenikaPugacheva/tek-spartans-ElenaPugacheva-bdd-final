package base;
import browsers.BaseBrowser;
import browsers.ChromeBrowser;
import browsers.EdgeBrowser;
import browsers.FireFoxBrowser;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    private static WebDriver driver;
    private final Properties properties;
    public BaseSetup(){
        try{
            String configFilePath = System.getProperty("user.dir")+"/src/test/resources/configs/dev-config.properties";
            LOGGER.info("Reading Config file " + configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException ex) {
            LOGGER.error("Error reading config file", ex);
            throw new RuntimeException("Something wrong with Config file", ex);
        }
    }
    public void setupBrowser() {
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser {} and isHeadless {}", browserType, isHeadless);
        BaseBrowser browser;
        if(browserType.equalsIgnoreCase("chrome"))
            browser = new ChromeBrowser();
        else if (browserType.equalsIgnoreCase("edge"))
            browser = new EdgeBrowser();
        else if (browserType.equalsIgnoreCase("firefox"))
            browser = new FireFoxBrowser();
        else
            throw new RuntimeException("Wrong browser type choose between chrome, firefox or edge");
        driver = browser.openBrowser(isHeadless);
        String url = properties.getProperty("ui.url");
        LOGGER.debug("Using URL {}", url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void quitBrowser() {
        //null check before quit
        if (driver != null) {
            driver.quit();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
    public String getPageTitle() {
        return getDriver().getTitle();
    }
}