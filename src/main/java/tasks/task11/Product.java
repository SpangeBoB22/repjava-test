package tasks.task11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product {
    private final WebDriver driver;

    By addCardLink = By.linkText("Add to cart");
    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public void addCard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver -> driver.findElement(addCardLink));

        driver.findElement(addCardLink).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        if(!alert.getText().equals("Product added.")) {
            throw  new RuntimeException("Problem added product");
        }
        alert.accept();
    }
}
