package com.codecool.saucedemo.tests;

import com.codecool.saucedemo.base.BaseTest;
import com.codecool.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private static final String VALID_USERNAME = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";

    @Test
    void userShouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(VALID_USERNAME, VALID_PASSWORD);

        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("inventory.html"));
    }

    @Test
    void userShouldNotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(VALID_USERNAME, "wrong_password");

        assertTrue(loginPage.getErrorMessage().contains(
                "Username and password do not match"
        ));
    }

    @Test
    void userShouldNotLoginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", VALID_PASSWORD);

        assertTrue(loginPage.getErrorMessage().contains(
                "Username and password do not match"
        ));
    }

    @Test
    void userShouldNotLoginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", VALID_PASSWORD);

        assertTrue(loginPage.getErrorMessage().contains(
                "Username is required"
        ));
    }

    @Test
    void userShouldNotLoginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(VALID_USERNAME, "");

        assertTrue(loginPage.getErrorMessage().contains(
                "Password is required"
        ));
    }
}
