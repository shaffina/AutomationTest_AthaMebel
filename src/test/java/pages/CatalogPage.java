package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CatalogPage {
    WebDriver driver;
    WebDriverWait wait;

    By catalogItem = By.xpath("//*[@id='catalog-container']/button[2]");
    By modal = By.id("default-modal");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCatalogItem() {
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(catalogItem));
        item.click();
    }

    public boolean isModalDisplayed() {
        // Extend the wait time specifically for the modal
        WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalElement = modalWait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        return modalElement.isDisplayed();
    }
}
