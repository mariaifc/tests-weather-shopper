package com.tests;

import com.page_objects.*;
import com.utils.Card;
import com.utils.Log;
import com.utils.Product;
import com.utils.Randomizer;
import org.junit.Assert;
import org.testng.annotations.Test;

public class WeatherShopperTest extends com.tests.BaseTest {

    @Test
    public void testBuySunscreensOrMoisturizersAccordingToTheTemperature() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitForPage();

        int temperature = homePage.getTemperature();
        Log.info("Temperature is " + temperature);

        Product productOne;
        Product productTwo;
        ProductsPage productsPage;

        if (temperature < 19) {
            Log.info("Buying moisturizers...");
            homePage.clickOnBuyMoisturizersButton();

            productsPage = new ProductsPage(driver, "moisturizer");
            productsPage.waitForPage();

            productOne = productsPage.selectTheCheapestOneThatContainsValue("Aloe");
            productTwo = productsPage.selectTheCheapestOneThatContainsValue("Almond");

        } else if (temperature > 34) {
            Log.info("Buying sunscreens...");
            homePage.clickOnBuySunscreensButton();

            productsPage = new ProductsPage(driver, "sunscreen");
            productsPage.waitForPage();

            productOne = productsPage.selectTheCheapestOneThatContainsValue("SPF-50");
            productTwo = productsPage.selectTheCheapestOneThatContainsValue("SPF-30");

        } else {
            throw new RuntimeException("The weather does not require any shopping skin related");
        }

        Log.info(String.format("First Cheapest product- name: %s and price %s",
                productOne.getName(), productOne.getPrice()));
        Log.info(String.format("Second Cheapest product- name: %s and price %s",
                productTwo.getName(), productTwo.getPrice()));

        Assert.assertEquals("Number of items in cart is incorrect",2, productsPage.getNumberOfItemsInCart());

        productsPage.clickOnCartButton();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals("Number of items is incorrect", 2, cartPage.getNumberOfItems());

        Assert.assertEquals("Total is incorrect", productOne.getPrice() + productTwo.getPrice(),
                cartPage.getTotal());

        Log.info("Cart total price is displayed as " + cartPage.getTotal());

        cartPage.clickOnPayWithCartButton();

        CheckoutStripePage checkoutStripePage = new CheckoutStripePage(driver);
        checkoutStripePage.waitForPage();

        checkoutStripePage.inputEmail(Randomizer.getRandomEmail());
        checkoutStripePage.inputCardNumber(Card.VISA.getCardNumber());
        checkoutStripePage.inputExpirationDate(Card.VISA.getExpirationDate());
        checkoutStripePage.inputCVC(Card.VISA.getCvc());
        checkoutStripePage.inputPostalCode(Randomizer.getRandomZipCode());

        checkoutStripePage.clickSubmitButton();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.waitForPage();

        Assert.assertEquals("Payment is not successful", confirmationPage.getHeaderText(),
                "PAYMENT SUCCESS");

        Assert.assertTrue("Text message is incorrect",
                confirmationPage.getTextMessage().contains("Your payment was successful"));
    }
}
