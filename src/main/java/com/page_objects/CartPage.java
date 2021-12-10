package com.page_objects;

import com.utils.StringHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "tbody tr")
    private List<WebElement> items;
    @FindBy(css = "#total")
    private WebElement cartTotal;
    @FindBy(css = "button.stripe-button-el")
    private WebElement payWithCardButton;

    private final static String URL = "cart";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPage() {
        waitVisibilityOfElement(cartTotal);
    }

    public void clickOnPayWithCartButton() {
        payWithCardButton.click();
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public int getTotal() {
        return StringHelper.getDigitsOnly(cartTotal.getText());
    }
}
