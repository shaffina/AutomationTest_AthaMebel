package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExtentReportUtil;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ExtentReportUtil extentReportUtil;
    private static final String TEST_NAME = "Login Test";

    @Given("The admin is on the login page")
    public void the_admin_is_on_the_login_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver126\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://127.0.0.1:8000/login");
        loginPage = new LoginPage(driver);
        extentReportUtil = new ExtentReportUtil();
        extentReportUtil.startTest(TEST_NAME);
        extentReportUtil.logPass(TEST_NAME, "Admin navigates to login page");
    }

    @When("The admin enters the email {string}")
    public void the_admin_enters_the_email(String email) {
        loginPage.setEmail(email);
        extentReportUtil.logPass(TEST_NAME, "Admin enters email: " + email);
    }

    @When("The admin enters the password {string}")
    public void the_admin_enters_the_password(String password) {
        loginPage.setPassword(password);
        extentReportUtil.logPass(TEST_NAME, "Admin enters password");
    }

    @When("The admin clicks the login button")
    public void the_admin_clicks_the_login_button() {
        loginPage.clickLoginButton();
        extentReportUtil.logPass(TEST_NAME, "Admin clicks login button");
    }

    @Then("The admin should be logged in successfully")
    public void the_admin_should_be_logged_in_successfully() {
        extentReportUtil.logPass(TEST_NAME, "Admin logged in successfully");
        extentReportUtil.takeScreenshot(driver, TEST_NAME, "LoginSuccess");
        extentReportUtil.endTest(TEST_NAME);
    }
}
