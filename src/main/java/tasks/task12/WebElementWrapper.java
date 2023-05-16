package tasks.task12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementWrapper {
    WebDriver driver;
    String tagName;
    WebElement element;

    protected WebElementWrapper(WebDriver driver, WebElement element, String tagName) {
        if (!element.getTagName().equals(tagName)) {
            throw new RuntimeException("Expected " + tagName + " element, but " + element.getTagName() + " found");
        }

        this.driver = driver;
        this.element = element;
    }

    public WebElementWrapper(WebDriver driver, String tagName) {
        this.driver = driver;
        this.tagName = tagName;
    }

    protected WebElement element() {
        return element;
    }

    protected WebDriver driver() {
        return driver;
    }

    public void click() {
        element.click();
    }

    public String getUrl() {
        return element.getAttribute("href");
    }

    public boolean isClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
