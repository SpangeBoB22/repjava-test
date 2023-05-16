package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Utils {
    public static List<Person> persons() {
        List<Person> personList = new ArrayList<>();
        personList.add(
                Person.builder()
                        .name("Sophie")
                        .age(73)
                        .address(
                                Address
                                        .builder()
                                        .state("Utah")
                                        .city("Metropolis")
                                        .street("Main")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Chase")
                        .age(32)
                        .address(
                                Address
                                        .builder()
                                        .state("Alabama")
                                        .city("Braavos")
                                        .street("Pearl")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Koda")
                        .age(47)
                        .address(
                                Address
                                        .builder()
                                        .state("Oregon")
                                        .city("Blackwater")
                                        .street("Hill")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Roland")
                        .age(27)
                        .address(
                                Address
                                        .builder()
                                        .state("Colorado")
                                        .city("Dawnstar")
                                        .street("Hill")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Ruben")
                        .age(76)
                        .address(
                                Address
                                        .builder()
                                        .state("South Carolina")
                                        .city("Westworld")
                                        .street("Washington")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Wendy")
                        .age(48)
                        .address(
                                Address
                                        .builder()
                                        .state("Alabama")
                                        .city("Balmora")
                                        .street("High")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Rey")
                        .age(34)
                        .address(
                                Address
                                        .builder()
                                        .state("Utah")
                                        .city("King's Landing")
                                        .street("Hill")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Clyde")
                        .age(39)
                        .address(
                                Address
                                        .builder()
                                        .state("Palau")
                                        .city("Gotham")
                                        .street("Maple")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Avery")
                        .age(63)
                        .address(
                                Address
                                        .builder()
                                        .state("Mississippi")
                                        .city("Winterfell")
                                        .street("Main")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        personList.add(
                Person.builder()
                        .name("Carmelo")
                        .age(62)
                        .address(
                                Address
                                        .builder()
                                        .state("Palau")
                                        .city("Eerie")
                                        .street("Lake")
                                        .build())
                        .interest(new HashSet<>())
                        .projects(new HashSet<>())
                        .build()
        );
        return personList;
    }
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        Dimension dm = new Dimension(1552, 849);
        driver.manage().window().setSize(dm);
        return driver;
    }
    public static void waitScripts(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(500)).until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
