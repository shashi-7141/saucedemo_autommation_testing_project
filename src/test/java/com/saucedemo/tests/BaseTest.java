package com.saucedemo.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.saucedemo.utils.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeMethod 
    public void setUp(){
        driver = DriverFactory.createDriver();
        
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));

        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod 
    public void tearDown(){
        DriverFactory.quitDriver(driver);
    }
    

    public void takeScreenShot(String fileName) throws IOException{

        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);

        Path destination = Path.of("screenshot", fileName + ".png");

        Files.createDirectories(destination.getParent());

        Files.copy(source.toPath(),destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);


    }
}
