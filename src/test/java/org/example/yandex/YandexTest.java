package org.example.yandex;

import org.example.core.ConfProperties;
import org.example.core.WaitUtil;
import org.example.yandex.pages.LoginPage;
import org.example.yandex.pages.ProfilePage;
import org.example.yandex.pages.QrCodePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class YandexTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static QrCodePage qrCodePage;
    public static WebDriver driver;

    @BeforeAll
    static void init(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        qrCodePage = new QrCodePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("url.yandex"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void runTest(){
        WaitUtil.sleep(2000);
        loginPage.move();
        loginPage.inputLogin("login");
        loginPage.clickLoginBtn();
        loginPage.inputPasswd("password");
        WaitUtil.sleep(2000);
        loginPage.clickCont();
        WebElement webElement = driver.findElement(By.xpath("//span[@class=\"DefaultTitle\"]"));
        assertThat(webElement.isDisplayed()).isTrue();
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }
}


