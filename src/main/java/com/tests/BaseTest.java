package com.tests;

import com.utils.WebDriverProvider;
import com.utils.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        driver = WebDriverProvider.getDriver(browser);
    }

    @BeforeClass
    public void logTestClassName() {
        Log.testClassName(this.getClass());
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
