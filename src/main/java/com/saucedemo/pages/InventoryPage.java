package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage{

    private By backPackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addTShirtToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By cartButton = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart() {
        wait.until(
            ExpectedConditions.elementToBeClickable(backPackAddToCartButton)
        );
        driver.findElement(backPackAddToCartButton).click();
    }

    public void addTShirtToCart(){
        wait.until(
            ExpectedConditions.elementToBeClickable(addTShirtToCartButton)
        );
    }

    public void clickToCartButton(){
        wait.until(
            ExpectedConditions.elementToBeClickable(cartButton)
        );
        driver.findElement(cartButton).click();
    }

}