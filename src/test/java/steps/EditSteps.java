package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditPage;
import pages.LoginPage;
import utils.ExtentReportUtil;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EditSteps {
    WebDriver driver;
    LoginPage loginPage;
    EditPage editPage;
    ExtentReportUtil extentReportUtil;
    private static final String TEST_NAME = "Edit Test";


    @Given("User is logged in using admin account")
    public void user_is_logged_in_using_admin_account() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver126\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login");

        loginPage = new LoginPage(driver);
        loginPage.setEmail("admin@gmail.com");
        loginPage.setPassword("rahasia");
        loginPage.clickLoginButton();

        extentReportUtil = new ExtentReportUtil();
        extentReportUtil.startTest(TEST_NAME);
        extentReportUtil.logPass(TEST_NAME, "User is logged in using admin account");
    }

    @And("user navigated to the update catalog page")
    public void user_navigated_to_the_update_catalog_page() {
        driver.get("http://127.0.0.1:8000/dashboard/catalogs/6/edit");
        editPage = new EditPage(driver);
        extentReportUtil.logPass(TEST_NAME, "user navigated to the update catalog page");
    }

    @When("user updates the product with valid details")
    public void user_updates_the_product_with_valid_details() {
        editPage.setName("New Product");
        editPage.clickSaveButton();
        extentReportUtil.logPass(TEST_NAME, "user updates the product with valid details");
    }

    @Then("user should be redirected to all product page")
    public void user_should_be_redirected_to_all_product_page() {
        driver.get("http://127.0.0.1:8000/catalogtable");
        extentReportUtil.logPass(TEST_NAME, "ser should be redirected to all product page");
        extentReportUtil.takeScreenshot(driver, TEST_NAME, "EditSuccess");
        extentReportUtil.endTest(TEST_NAME);
    }
}
