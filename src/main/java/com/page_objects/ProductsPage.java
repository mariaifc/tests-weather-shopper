package com.page_objects;

import main.java.com.utils.Product;
import com.utils.StringHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "button.thin-text")
    private WebElement cartButton;
    @FindBy(className = "text-center col-4")
    private List<WebElement> products;
    @FindBy(css = "#cart")
    private WebElement cartLabel;

    private String category;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage(WebDriver driver, String category) {
        super(driver);
        this.category = category;
    }

    @Override
    public void waitForPage() {
        waitVisibilityOfElement(cartButton);
    }


    public void open() {
        getUrl(String.format("/%s",category));
        waitForPage();
    }

    public void clickOnCartButton() {
        waitVisibilityOfElement(cartButton);
        cartButton.click();
    }

    public Product selectTheCheapestOneThatContainsValue(String value) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.text-center.col-4"));
        int cheapestProductPrice = 100000000;
        int cheapestProductIndex = -1;
        String cheapestProductName = null;

        List<WebElement> children;
        for (int i = 0; i < products.size(); i++) {
            children = products.get(i).findElements(By.cssSelector("*"));
            if (children.get(1).getText().contains(value)) {
                if (StringHelper.getDigitsOnly(children.get(2).getText()) < cheapestProductPrice){
                    cheapestProductPrice = StringHelper.getDigitsOnly(children.get(2).getText());
                    cheapestProductIndex = i;
                    cheapestProductName = children.get(1).getText();
                }
            }
        }

        products.get(cheapestProductIndex).findElements(By.cssSelector("*")).get(3).click();
        return Product.builder().name(cheapestProductName).price(cheapestProductPrice).build();
    }

    public int getNumberOfItemsInCart() {
        waitVisibilityOfElement(cartLabel);
        return StringHelper.getDigitsOnly(cartLabel.getText());
    }
}
