package tasks.task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Card {
    private final WebDriver driver;

    By total = By.id("totalp");

    public Card(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(driver -> driver.findElement(total).getText().length() != 0 );
        return driver.findElement(By.id("totalp")).getText();
    }
}
