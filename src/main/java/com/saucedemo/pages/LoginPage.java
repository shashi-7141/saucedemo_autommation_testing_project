package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id
    ("password");
    private By loginButton = By.id("login-button");


    //super(driver) means:"Send this driver to the parent class, BasePage."
    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }
}