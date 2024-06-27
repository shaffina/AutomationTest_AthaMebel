package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pages.CatalogPage;
import utils.ExtentReportUtil;

public class CatalogSteps {
    WebDriver driver;
    CatalogPage catalogPage;
    ExtentReportUtil extentReportUtil;
    private static final String TEST_NAME = "Catalog Test";

    @Given("User is on the catalog page")
    public void user_is_on_the_catalog_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver126\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000");
        catalogPage = new CatalogPage(driver);
        extentReportUtil = new ExtentReportUtil();
        extentReportUtil.startTest(TEST_NAME);
        extentReportUtil.logPass(TEST_NAME, "User navigates to catalog page");
    }

    @When("User clicks on the catalog item")
    public void user_clicks_on_the_catalog_item() {
        catalogPage.clickCatalogItem();
        extentReportUtil.logPass(TEST_NAME, "User clicks on the catalog item");
    }

    @Then("User should see the catalog item modal")
    public void user_should_see_the_catalog_item_modal() {
        boolean isModalDisplayed = catalogPage.isModalDisplayed();
        try {
            Assert.assertTrue("The modal should be displayed after clicking the catalog item", isModalDisplayed);
            extentReportUtil.logPass(TEST_NAME, "The modal is displayed after clicking the catalog item");
        } catch (AssertionError e) {
            extentReportUtil.logFail(TEST_NAME, "The modal is not displayed after clicking the catalog item");
            extentReportUtil.takeScreenshot(driver, TEST_NAME, "CatalogItemModalFail");
            throw e; // rethrow the exception to ensure the test fails
        } finally {
            extentReportUtil.takeScreenshot(driver, TEST_NAME, "CatalogItemModal");
            extentReportUtil.endTest(TEST_NAME);
        }
    }
}
