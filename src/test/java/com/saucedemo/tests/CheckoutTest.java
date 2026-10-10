package com.saucedemo.tests;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.saucedemo.utils.DriverFactory;
import java.io.IOException;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkoutTest() throws InterruptedException, IOException{

        // Create an instance of the LoginPage class driver is already initialized in the BaseTest class

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();
        //WAITING FOR 2 SEC
        DriverFactory.pause(2);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.clickToCartButton();
        DriverFactory.pause(2);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.enterFirstName("Shashi");
        checkoutPage.enterLastName("Bokephode");
        checkoutPage.enterPostalCode("415006");

        DriverFactory.pause(1);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
        DriverFactory.pause(2);

        takeScreenShot("backpack-added-to-cart");

        Assert.assertEquals(
            checkoutPage.getConfirmationMessage(),"Thank you for your order!"
        );
    }

    @Test
    public void confirmationMessageTest () throws IOException{

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();
        DriverFactory.pause(2);

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addTShirtToCart();
        inventoryPage.clickToCartButton();
        DriverFactory.pause(1);

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickCheckout();
        checkoutPage.enterFirstName("Shivam");
        checkoutPage.enterLastName("Raut");
        checkoutPage.enterPostalCode("415004");

        DriverFactory.pause(1);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");

        takeScreenShot("T-Shirt-added-to-cart");
    }
}