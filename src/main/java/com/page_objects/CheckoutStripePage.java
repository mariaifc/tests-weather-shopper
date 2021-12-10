package com.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStripePage extends BasePage {

    @FindBy(css = "[type='email']")
    private WebElement emailInput;
    @FindBy(css = "input#card_number")
    private WebElement cardNumberInput;
    @FindBy(id = "cc-exp")
    private WebElement ccExpInput;
    @FindBy(id = "cc-csc")
    private WebElement ccCscInput;
    @FindBy(id = "submitButton")
    private WebElement submitButton;
    @FindBy(name = "zip")
    private WebElement postalCodeInput;

    public CheckoutStripePage(WebDriver driver) {
        super(driver);
        switchToIFrame();
    }

    @Override
    public void waitForPage() {
        waitVisibilityOfElement(emailInput);
    }


    public void clickSubmitButton() {
        submitButton.click();
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.cssSelector("[frameborder]")));
    }

    public void inputCardNumber(String cardNumber) {
        inputStringAsInteger(cardNumber, cardNumberInput);
    }

    public void inputExpirationDate(String expirationDate) {
        inputStringAsInteger(expirationDate, ccExpInput);
    }

    public void inputCVC(String cvc) {
        ccCscInput.sendKeys(cvc);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }
}
