package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class CartPage extends BasePage{

    private By backPackItem = By.className("inventory_item_name");
    private By productName = By.className("inventory_item_name");

    private By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_link");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getBackPackItemText(){
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(backPackItem)
        );
        return driver.findElement(backPackItem).getText();
    }

    public String getProductName(){
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(productName)
        );
        return driver.findElement(productName).getText();
    }

    public void removeProductFromCart(){
        wait.until(
            ExpectedConditions.elementToBeClickable(removeBackpackButton)
        ).click();;
    }

    public void verifyProductRemovedFromCart(){
        wait.until(
            ExpectedConditions.elementToBeClickable(cartBadge)
        ).click();
    }
}