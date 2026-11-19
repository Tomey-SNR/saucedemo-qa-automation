package com.codecool.saucedemo.tests;

import com.codecool.saucedemo.base.BaseTest;
import com.codecool.saucedemo.pages.InventoryPage;
import com.codecool.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    void userShouldBeRedirectedToLoginPageAfterLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();

        assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login page should be displayed after logout"
        );
    }

    @Test
    void userShouldNotAccessInventoryAfterLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();

        driver.get("https://www.saucedemo.com/inventory.html");

        assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "User should be redirected to the login page when accessing inventory after logout"
        );
    }
}
