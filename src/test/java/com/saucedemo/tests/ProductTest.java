
package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.utils.DriverFactory;

public class ProductTest extends BaseTest {

    @Test
    public void addBackpackToCartTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLogin();
        DriverFactory.pause(2);

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();
        inventoryPage.clickToCartButton();

        DriverFactory.pause(1);

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack"
        );
        DriverFactory.pause(1);
    }

    @Test
    public void addBackPackToCartScreenshotTest() throws IOException{
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        inventoryPage.clickToCartButton();

        takeScreenShot("backpack-added-to-cart");
    }
}

