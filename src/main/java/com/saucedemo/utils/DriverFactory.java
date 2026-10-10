package com.saucedemo.utils;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption(
            "prefs",
            Map.of("profile.password_manager_leak_detection", false)
        );

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        return driver;
    }

    public static void quitDriver(WebDriver driver) {

        if (driver != null) {
            driver.quit();
        }
    }

    //Using wait to slow down the application
     public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}