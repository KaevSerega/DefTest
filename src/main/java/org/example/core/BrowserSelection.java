package org.example.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class BrowserSelection {

    public static WebDriver browserSelection() {
        WebDriver driver;
        if (Objects.equals(ConfProperties.getProperty("browser"), "chrome")) {
            driver = new ChromeDriver();
        } else if (Objects.equals(ConfProperties.getProperty("browser"), "firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Неизвестный браузер");
        }
        return driver;
    }

}
