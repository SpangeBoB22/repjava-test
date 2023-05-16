package tasks.task11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private final By signUp = By.id("signin2");
    private final By signUpUserName = By.id("sign-username");
    private final By signUpPassword = By.id("sign-password");
    private final By buttonSignUp = By.cssSelector("#signInModal .btn-primary");
    //btn-secondary
    private final By buttonClose = By.cssSelector("#signInModal .btn-secondary");

    private  final WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;

    }

    public void loadPage() {
        driver.findElement(By.xpath("//a[@data-target='#signInModal']")).click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(text(),'Sign up')]")));
    }
    public void typeSignUpUserName(String username) {
        driver.findElement(signUpUserName).sendKeys(username);
    }
    public void typeSignUpPassword(String password) {
        driver.findElement(signUpPassword).sendKeys(password);
    }

    public void submitSignUp() {
        driver.findElement(buttonSignUp).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        if(alert.getText().equals("This user already exist.")) {
            alert.accept();
            driver.findElement(buttonClose).click();
        } else {
            alert.accept();
        }
    }
}
