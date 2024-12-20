package ru.ugrasu.testingcourse.lab.six;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    List<WebDriver> webDrivers;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeEach
    void setup() {
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firefoxDriver.manage().window().maximize();

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.manage().window().maximize();

        webDrivers = List.of(firefoxDriver, chromeDriver);
    }

    @AfterEach
    void teardown() {
        webDrivers.forEach(WebDriver::quit);
    }

    private void authorization(WebDriver webDriver) {
        webDriver.findElement(By.cssSelector("a[data-qa='login']"))
                .click();

        webDriver.findElement(By.cssSelector("span[data-qa='expand-login-by-password-text']"))
                .click();

        WebElement usernameField = webDriver.findElement(By.cssSelector("input[data-qa='login-input-username']"));
        WebElement passwordField = webDriver.findElement(By.cssSelector("input[data-qa='login-input-password']"));

        usernameField.sendKeys("79825107380");
        passwordField.sendKeys("asdfasdfFD");

        webDriver.findElement(By.cssSelector("button[data-qa='account-login-submit']"))
                .click();
    }

    @Test
    void testAuthorization() {
        for (WebDriver webDriver : webDrivers) {
            webDriver.get("https://hh.ru/");

            authorization(webDriver);

            webDriver.findElement(By.cssSelector("div[data-qa='mainmenu_myResumes']"))
                    .click();
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement profileNameBlock = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div[data-qa='profile-activator-fullname']")));

            Assertions.assertTrue(profileNameBlock.getText().contains("Кирилл Одинцов"),
                    "Имя пользователя 'Кирилл Одинцов' не отображается на странице");
        }
    }

    @Test
    void testVacancyRequestResponse() {
        for (WebDriver webDriver : webDrivers) {
            webDriver.get("https://hh.ru/");

            authorization(webDriver);

            webDriver.findElement(By.cssSelector("a[data-qa='vacancy-serp__vacancy_response']"))
                    .click();

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement response = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div[data-qa='vacancy-serp__vacancy_responded']")));

            Assertions.assertTrue(response.getText().contains("Вы откликнулись"),
                    "Произошла ошибка при отклике");
        }
    }

    @Test
    void testVacancySearch() {
        for (WebDriver webDriver : webDrivers) {
            webDriver.get("https://hh.ru/");

            webDriver.findElement(By.cssSelector("input[data-qa='search-input']"))
                    .sendKeys("Java разработчик");

            webDriver.findElement(By.cssSelector("button[data-qa='search-button']"))
                    .click();

            webDriver.findElement(By.cssSelector("div[data-qa='bloko-modal-close']"))
                    .click();

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            WebElement response = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("h1[data-qa='title']")));

            Assertions.assertTrue(response.getText().contains("Java разработчик"),
                    "Произошла ошибка при поиске");
        }
    }

    @Test
    void testAddVacancyTo() {
        for (WebDriver webDriver : webDrivers) {
            webDriver.get("https://hh.ru/");

            authorization(webDriver);

            webDriver.findElement(By.cssSelector("button[data-qa='vacancy-search-mark-favorite_false']"))
                    .click();

            webDriver.findElement(By.cssSelector("div[data-qa='mainmenu_favVacancies']"))
                    .click();

            webDriver.findElement(By.cssSelector("button[data-qa='vacancy-search-mark-favorite_true']"))
                    .click();
        }
    }
}
