package tasks.task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By loginUserName =  By.id("loginusername");
    private final By loginPassword = By.id("loginpassword");
    private final By buttonLoginSubmit = By.cssSelector("#logInModal .btn-primary");

    private  final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void typeSignUpUserName(String username) {
        driver.findElement(loginUserName).sendKeys(username);
    }
    public void typeSignUpPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void submitLogin() {
        driver.findElement(buttonLoginSubmit).click();
    }

}
