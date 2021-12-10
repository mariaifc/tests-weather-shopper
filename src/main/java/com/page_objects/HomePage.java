package com.page_objects;

import com.utils.StringHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "temperature")
    private WebElement temperature;
    @FindBy(linkText = "Buy moisturizers")
    private WebElement buyMoisturizersButton;
    @FindBy(linkText = "Buy sunscreens")
    private WebElement buySunscreensButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waitVisibilityOfElement(temperature);
    }

    public int getTemperature() {
        return StringHelper.getDigitsOnly(temperature.getText());
    }

    public void open() {
        getUrl("");
    }

    public void clickOnBuyMoisturizersButton() {
        buyMoisturizersButton.click();
    }

    public void clickOnBuySunscreensButton() {
        buySunscreensButton.click();
    }




}
