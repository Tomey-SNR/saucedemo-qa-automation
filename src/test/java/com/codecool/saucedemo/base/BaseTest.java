package com.codecool.saucedemo.base;

import com.codecool.saucedemo.config.DriverFactory;
import com.codecool.saucedemo.config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    protected void setUp() {
        driver = new DriverFactory().createDriver();
        driver.manage().window().maximize();
        driver.get(TestConfig.BASE_URL);
    }

    @AfterEach
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
