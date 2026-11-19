package com.codecool.saucedemo.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}
