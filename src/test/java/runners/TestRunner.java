package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "steps",
        dryRun = false,
        tags = "",
        plugin = {        "html:target/cucumber_report/index.html",
                          "json:target/jsonReport/report.json"
        }
)
public class TestRunner {
}


