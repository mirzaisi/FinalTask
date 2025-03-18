package com.finaltask;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "firefox");
        driver = DriverFactory.getInstance().getDriver(browser);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverFactory.getInstance().quitDriver();
    }
}
