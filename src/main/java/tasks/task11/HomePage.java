package tasks.task11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tasks.Utils;

import java.time.Duration;

public class HomePage {

    private final By loginUserName = By.id("nameofuser");
    private final By pageLogin = By.id("login2");
    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void load(String homePageUrl) {
        driver.get(homePageUrl);
        driver.manage().window().setSize(new Dimension(1047, 678));
        Utils.waitScripts(driver);
    }
    public void loadLoginPage() {
        driver.findElement(pageLogin).click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable( By.cssSelector("#logInModal .btn-primary") ) );
    }
    public void isLoginUserName(String userName) {
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginUserName));
        System.out.println(userName);
        System.out.println(driver.findElement(loginUserName).getText());
        if(!driver.findElement(loginUserName).getText().equals("Welcome " + userName)) {
            throw new RuntimeException("Error login");
        }
        System.out.println(driver.findElement(loginUserName).getText());
    }
    public void loadPageProduct(String productTitle) {
        driver.findElement(By.linkText(productTitle)).click();
    }
    public void loadCardPage() {
        driver.findElement(By.id("cartur")).click();
        System.out.println(driver.getCurrentUrl());
    }
    private void waitScripts(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(500)).until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
