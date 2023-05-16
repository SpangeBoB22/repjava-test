package tasks.task11;

import org.openqa.selenium.WebDriver;
import tasks.Utils;

import java.util.Random;

public class Task11 {

    WebDriver driver;
    public void run() {
        String userName = "test" + getRandomNumberUsingInts(1, 900) + "@test.com";
        String password = "test" + getRandomNumberUsingInts(1, 900);
        System.out.println(userName + ":" + password);
        String homePageUrl = "https://www.demoblaze.com/";

        driver = Utils.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.load(homePageUrl);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.loadPage();
        signUpPage.typeSignUpUserName(userName);
        signUpPage.typeSignUpPassword(password);
        signUpPage.submitSignUp();

        System.out.println("URL");
        System.out.println(driver.getCurrentUrl());
        homePage.loadLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeSignUpUserName(userName);
        loginPage.typeSignUpPassword(password);
        loginPage.submitLogin();
        homePage.isLoginUserName(userName);

        homePage.loadPageProduct("Samsung galaxy s6");
        //"Samsung galaxy s6"
        Product product = new Product(driver);
        product.addCard();

        homePage.loadCardPage();

        Card card = new Card(driver);
        String totalInCard = card.getTotal();
        System.out.println(totalInCard);
        if(totalInCard.equals("360")) {
            System.out.println("Is Ok");
        } else {
            throw  new RuntimeException(("Error load total cost product"));
        }
        driver.quit();
    }

    private int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
