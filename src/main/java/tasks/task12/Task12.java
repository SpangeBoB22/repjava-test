package tasks.task12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tasks.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task12 {

    public void run() {
        WebDriver driver = Utils.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openHyperlink();
        driver.quit();

        driver = Utils.getDriver();
        driver.get("https://www.demoblaze.com/");

        WebElementWrapper homeWrapper = new WebElementWrapper(driver, driver.findElement(By.xpath("//a[@data-target='#signInModal']")), "a");
        System.out.println("[Wrapper] Hyperlink clickable: " + homeWrapper.isClickable());
        System.out.println("[Wrapper] Hyperlink url: " + homeWrapper.getUrl());
        homeWrapper.click();
        System.out.println("[Wrapper] Hyperlink click");
        driver.quit();
    }
}
