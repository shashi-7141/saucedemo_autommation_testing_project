package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.saucedemo.utils.DriverFactory;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() throws InterruptedException {

        //when you create an instance of the LoginPage class, you need to pass the driver as an argument to the constructor. This is because the LoginPage class requires a WebDriver instance to interact with the web elements on the login page.

        //when you create an object of the login page then driver goes to super class constructor and then driver is initialized in the base page class. So, you can use the driver in the login page class.
        
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();
        DriverFactory.pause(1);

        Assert.assertEquals(
            driver.getCurrentUrl(),
            "https://www.saucedemo.com/inventory.html"
        );
    }
}