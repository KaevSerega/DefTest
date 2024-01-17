package org.example.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(xpath = "//input[@autocomplete=\"username\"]")
    private WebElement userName;
    //input[@autocomplete="username"]

    @FindBy(xpath ="//button[@data-t=\"button:pseudo:qr-button\"] ")
    private WebElement continPass;


    //button[@data-t="button:action:passp:sign-in"]
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void clickCont(){
        continPass.click();
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void move() {
        Actions actions = new Actions(driver);
        actions.moveToElement(userName).perform();
        userName.click();
    }
}
