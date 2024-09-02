package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {
    @Before
    public void befoeEachScenaio(){
        setupBrowser();
    }
    @After
    public void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = takeScreenshot();
            scenario.attach(screenshot, "image/png", "failed_scenario");
        }
        quitBrowser();
    }
}
