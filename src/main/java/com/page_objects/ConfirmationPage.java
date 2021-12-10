package com.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {

    @FindBy(css = "h2")
    private WebElement header;
    @FindBy(css = "p.text-justify")
    private WebElement text;

    private final static String URL = "confirmation";

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waitUntilUrlContains(URL);
        waitVisibilityOfElement(header);
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getTextMessage() {
        return text.getText();
    }
}
