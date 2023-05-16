package tasks.task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="signin2")
    WebElement hyperlink;

    public void openHyperlink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(hyperlink));
        System.out.println("Hyperlink is clickable");
        System.out.println("URL: " + hyperlink.getAttribute("href"));
        hyperlink.click();
        System.out.println("Hyperlink click");
    }
}
