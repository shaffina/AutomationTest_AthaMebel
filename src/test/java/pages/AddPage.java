package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPage {
    WebDriver driver;
    WebDriverWait wait;

    By nameField = By.xpath("//*[@id=\"product-title\"]");
    By descriptionField = By.xpath("//*[@id=\"product-description\"]");
    By imageField = By.xpath("//*[@id=\"dropzone-file\"]");
    By saveButton = By.xpath("//*[@id=\"catalog-form\"]/button");

    public AddPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void uploadImage(String imagePath) {
        driver.findElement(imageField).sendKeys(imagePath);
    }

    public void clickSaveButton() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveBtn.click();
    }
}

