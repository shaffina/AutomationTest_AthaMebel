package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddPage;
import pages.LoginPage;
import utils.ExtentReportUtil;

import java.util.concurrent.TimeUnit;

public class AddSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    AddPage addPage;
    ExtentReportUtil extentReportUtil;

    private static final String TEST_NAME = "Add Test";
    @Given("User is logged in")
    public void user_is_logged_in() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver126\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login");

        loginPage = new LoginPage(driver);
        loginPage.setEmail("admin@gmail.com");
        loginPage.setPassword("rahasia");
        loginPage.clickLoginButton();
        extentReportUtil = new ExtentReportUtil();
        extentReportUtil.startTest(TEST_NAME);
        extentReportUtil.logPass(TEST_NAME, "User is logged in");
    }

    @And("user navigated to the add catalog page")
    public void user_navigated_to_the_add_catalog_page() {
        driver.get("http://127.0.0.1:8000/catalogform");
        extentReportUtil.logPass(TEST_NAME, "ser navigated to the add catalog page");
    }

    @When("user adds the product with valid details")
    public void user_adds_the_product_with_valid_details() {
        addPage = new AddPage(driver);
        addPage.setName("Meja Baru");
        addPage.setDescription("New Product Description");
        addPage.uploadImage("C:\\Users\\LENOVO\\Downloads\\meja tv.png");
        addPage.clickSaveButton();
        extentReportUtil.logPass(TEST_NAME, "user adds the product with valid details");
    }

    @Then("user should be redirected to dashboard page")
    public void user_should_be_redirected_to_dashboard_page() {
        extentReportUtil.logPass(TEST_NAME, "user should be redirected to dashboard page");
        extentReportUtil.takeScreenshot(driver, TEST_NAME, "AddSuccess");
        extentReportUtil.endTest(TEST_NAME);
    }
}
