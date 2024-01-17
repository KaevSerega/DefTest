package org.example.wildberries.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "//*[@id=\"searchInput\"]")
    private WebElement search;

    @FindBy(xpath = "//span[@class=\"navbar-pc__icon navbar-pc__icon--basket\"]")
    private WebElement iconBasket;

    @FindBy(xpath = "//*[@ class=\"product-card__top-wrap\"][1]")
    private WebElement icon;

    @FindBy(xpath = "//*[@class=\"product-card__add-basket j-add-to-basket btn-main-sm\"][1]")
    private WebElement bay;

    @FindBy(xpath = "//ins[@class=\"price__lower-price\"]")
    private WebElement price;

    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void pressEnter() {
        search.sendKeys(Keys.ENTER);
    }

    public void moveMouseToIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(icon).perform();
    }

    public String getPrice() {
        return price.getText();
    }

    public void inputProduct(String product) {
        search.sendKeys(product);
    }

    public void clickBay() {
        bay.click();
    }

    public void clickBasket() {
        iconBasket.click();
    }
}
