package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

import org.testng.annotations.Test;
import com.saucedemo.utils.DriverFactory;


public class RemoveFromCartTest extends BaseTest{
    
    @Test 
    public void removeBackPackFromCartTest(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        DriverFactory.pause(1);
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();
        inventoryPage.clickToCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeProductFromCart();
        DriverFactory.pause(1);
        cartPage.verifyProductRemovedFromCart();

        
    }

}
