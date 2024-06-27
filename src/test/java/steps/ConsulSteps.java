package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConsulPage;
import utils.ExtentReportUtil;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConsulSteps {
    WebDriver driver;
    WebDriverWait wait;
    ConsulPage ConsulPage;
    ExtentReportUtil extentReportUtil;
    private static final String TEST_NAME = "Consultation Test";

    @Given("User is on the consul page")
    public void user_is_on_the_consul_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver126\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000");
        ConsulPage = new ConsulPage(driver);
        extentReportUtil = new ExtentReportUtil();
        extentReportUtil.startTest(TEST_NAME);
        extentReportUtil.logPass(TEST_NAME, "User navigates to consul page");
    }

    @When("User clicks on the Contact Us button")
    public void user_clicks_on_the_contact_us_button() {
        ConsulPage.clickContactUs();
        extentReportUtil.logPass(TEST_NAME, "User clicks on the Contact Us button");
    }

    @Then("User should see contact options")
    public void user_should_see_contact_options() {
        extentReportUtil.logPass(TEST_NAME,"User should see contact options");
        extentReportUtil.endTest(TEST_NAME);

    }

}
