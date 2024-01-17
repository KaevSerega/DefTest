package org.example.wildberries;

import org.example.core.BrowserSelection;
import org.example.core.ConfProperties;
import org.example.core.WaitUtil;
import org.example.wildberries.pages.BasketPage;
import org.example.wildberries.pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildberriesTest {

    public static BasketPage basketPage;

    public static SearchPage search;

    public static WebDriver driver;

    @BeforeAll
    static void init(){
        driver = BrowserSelection.browserSelection();
        search = new SearchPage(driver);
        basketPage = new BasketPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("url.wildberries"));
    }

    @Test
    public void runTest() {
        WaitUtil.sleep(Duration.ofSeconds(1));
        search.inputProduct("наушники");
        WaitUtil.sleep(Duration.ofSeconds(1));
        search.pressEnter();
        WaitUtil.sleep(Duration.ofSeconds(1));
        search.moveMouseToIcon();
        search.clickBay();
        String price1 = search.getPrice();
        WaitUtil.sleep(Duration.ofSeconds(1));
        search.clickBasket();
        WaitUtil.sleep(Duration.ofSeconds(1));
        String price2 = basketPage.getPrice();
        assertEquals(price1, price2);
    }

    @AfterAll
    static void close(){
        driver.close();
    }
}




