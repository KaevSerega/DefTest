package org.example.wildberries.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[2]/div/div/div/div[2]/p/span[2]")
    private WebElement price;

    public WebDriver driver;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getPrice() {
        return price.getText();
    }
}