package com.page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    private static final String URL = "https://weathershopper.pythonanywhere.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void getUrl(String partial) {
        driver.get(URL + partial);
    }

    abstract void waitForPage();

    public void waitVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void inputStringAsInteger(String cardNumber, WebElement element) {
        for (char ch : cardNumber.toCharArray()) {
            switch (Integer.parseInt(String.valueOf(ch))) {
                case 1:
                    element.sendKeys(Keys.NUMPAD1);
                    break;
                case 2:
                    element.sendKeys(Keys.NUMPAD2);
                    break;
                case 3:
                    element.sendKeys(Keys.NUMPAD3);
                    break;
                case 4:
                    element.sendKeys(Keys.NUMPAD4);
                    break;
                case 5:
                    element.sendKeys(Keys.NUMPAD5);
                    break;
                case 6:
                    element.sendKeys(Keys.NUMPAD6);
                    break;
                case 7:
                    element.sendKeys(Keys.NUMPAD7);
                    break;
                case 8:
                    element.sendKeys(Keys.NUMPAD8);
                    break;
                case 9:
                    element.sendKeys(Keys.NUMPAD9);
                    break;
                default:
                    element.sendKeys(Keys.NUMPAD0);
                    break;
            }
        }
    }

}
