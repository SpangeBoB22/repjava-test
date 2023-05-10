package tasks.task10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Task10 implements AutoCloseable {
    WebDriver driver = null;
    WebElement modal = null;
    Actions action = new Actions(getDriver());
    public void run() {
        WebElement label = getLabel();
        action.moveToElement(label).perform();

        WebElement inputUserName = getInputUserName();
        inputUserName.sendKeys("Test" +Keys.ENTER);

        WebElement inputPassword = getInputPassword();
        inputPassword.sendKeys("Password" +Keys.ENTER);

        WebElement modalSignupButton = getSignupButton();
        action.moveToElement(modalSignupButton).perform();

        System.out.println("Clicking modal close button");
        WebElement modalCloseButton = getCloseButton();

        modalCloseButton.click();

    }
    public WebElement getLabel() {
        return getIdElement("signInModalLabel");
    }
    public WebElement getInputPassword() {
        return getIdElement("sign-password");
    }
    public WebElement getInputUserName() {
        return getIdElement("sign-username");
    }
    public WebElement getSignupButton() {
        return findButtonByText("Sign up");
    }
    public WebElement getCloseButton() {
        return findButtonByText("Close");
    }
    private WebElement getClassElement(String className) {
        if(modal == null) {
            modal = getModal();
        }
        return modal.findElement(By.className(className));
    }
    private WebElement getIdElement(String id) {
        if(modal == null) {
            modal = getModal();
        }
        return modal.findElement(By.id(id));
    }
    private WebElement findButtonByText(String text) {
        if(modal == null) {
            modal = getModal();
        }
        return modal
                .findElement(By.xpath(".//button[contains(text(),'" + text + "')]"));
    }
    private WebElement getModal() {
        if(driver == null) {
            driver = getDriver();
        }
        driver.get("https://www.demoblaze.com/");
        waitScripts(driver);
        System.out.println("Clicking launch modal button");
        driver.findElement(By.xpath("//a[@data-target='#signInModal']")).click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(text(),'Sign up')]")));
        System.out.println(firstResult.getText());
        return driver.findElement(By.id("signInModal"));
    }
    private WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        Dimension dm = new Dimension(1552, 849);
        driver.manage().window().setSize(dm);
        return driver;
    }
    private void waitScripts(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(500)).until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    @Override
    public void close() throws IOException {
        assert driver != null;
        driver.quit();
    }
}
