package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utility.RandomEmail;
import utility.SeleniumUtility;
public class CommonSteps extends SeleniumUtility {
    public static String randomEmail;
    @Given("user click on {string} link")
    public void userClickOnLinks(String linkText) {
        clickOnElement(By.linkText(linkText));
    }
    @Then("user click on {string} button")
    public void user_click_on_button(String buttonVisibleText) {
        String buttonXpath = "//button[text()='" + buttonVisibleText + "']";
        clickOnElement(By.xpath(buttonXpath));
    }
    @When("user enter {string} on {string} field")
    public void userEnterTextToAnyField(String text, String fieldName) {
        String xpath = " //label[text()='"+fieldName+"']/..//input";
        sendText(By.xpath(xpath), text);
    }
    @Then("user enters {string} into {string} field")
    public void typeInFields(String text, String fieldName) {
        if (text.equalsIgnoreCase("random")){
            randomEmail = RandomEmail.EmailGenerator("eli");
            sendText(By.xpath("//label[text()='" + fieldName + "']/../input"), randomEmail);
        }else {
            sendText(By.xpath("//label[text()='" + fieldName + "']/../input"), text);
        }
    }
    @When("wait for {} seconds")
    public void waitForSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
