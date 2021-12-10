package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;

public class WebDriverProvider {

    public static WebDriver getDriver(String type) {
        if (type.equalsIgnoreCase(BrowserType.CHROME)) {
            return getLocalChrome();
        } else if (type.equalsIgnoreCase(BrowserType.EDGE)) {
            return getLocalEdge();
        } else {
            throw new IllegalStateException("Browser not supported");
        }
    }

    private static WebDriver getLocalEdge() {
        Log.info("Setting up Edge driver...");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver getLocalChrome() {
        Log.info("Setting up chrome driver...");
        ChromeOptions capabilities = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(capabilities);
    }
}
