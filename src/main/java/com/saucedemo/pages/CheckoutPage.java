package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class CheckoutPage extends BasePage{

    private By checkoutButton = By.id("checkout");

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");

    private By continueButton = By.id("continue");


    //super means "Send this driver to the parent class, BasePage."
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void clickCheckout(){
        wait.until(
            ExpectedConditions.elementToBeClickable(checkoutButton)
        );
        driver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstName){
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(lastNameField)
        );
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(postalCodeField)
        );
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue(){
        wait.until(
            ExpectedConditions.elementToBeClickable(continueButton)
        );
        driver.findElement(continueButton).click();
    }


    public void clickFinish(){
        wait.until (
            ExpectedConditions.elementToBeClickable(By.id("finish"))
        ).click();
    }

    public String getConfirmationMessage(){
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated
            (By.className("complete-header"))
        ).getText();
    }
}