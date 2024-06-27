package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsulPage {
    WebDriver driver;
    By contactButton = By.xpath("//*[@id='kontak']/*[@type='button']");

    public ConsulPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactUs() {
        driver.findElement(contactButton).click();
    }
}
