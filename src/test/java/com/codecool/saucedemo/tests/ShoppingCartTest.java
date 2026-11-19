package com.codecool.saucedemo.tests;

import com.codecool.saucedemo.base.BaseTest;
import com.codecool.saucedemo.pages.LoginPage;
import com.codecool.saucedemo.pages.ProductListPage;
import com.codecool.saucedemo.pages.ShoppingCartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    private static final String BACKPACK = "Sauce Labs Backpack";
    private static final String BIKE_LIGHT = "Sauce Labs Bike Light";

    private ProductListPage productListPage;
    private ShoppingCartPage shoppingCartPage;

    @BeforeEach
    void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        productListPage = new ProductListPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test
    void userShouldAddProductToCart() {
        productListPage.addBackpackToCart();
        productListPage.openShoppingCart();

        assertTrue(shoppingCartPage.isProductDisplayed(BACKPACK));
        assertEquals(1, shoppingCartPage.getCartItemCount());
    }

    @Test
    void userShouldAddMultipleProductsToCart() {
        productListPage.addBackpackToCart();
        productListPage.addBikeLightToCart();

        productListPage.openShoppingCart();

        assertEquals(2, shoppingCartPage.getCartItemCount());
        assertTrue(shoppingCartPage.isProductDisplayed(BACKPACK));
        assertTrue(shoppingCartPage.isProductDisplayed(BIKE_LIGHT));
    }

    @Test
    void addedProductsShouldBeDisplayedInCart() {
        productListPage.addBackpackToCart();
        productListPage.addBikeLightToCart();

        productListPage.openShoppingCart();

        assertTrue(shoppingCartPage.isProductDisplayed(BACKPACK));
        assertTrue(shoppingCartPage.isProductDisplayed(BIKE_LIGHT));
    }

    @Test
    void userShouldRemoveProductFromCart() {
        productListPage.addBackpackToCart();
        productListPage.addBikeLightToCart();

        productListPage.openShoppingCart();
        shoppingCartPage.removeFirstProduct();

        assertEquals(1, shoppingCartPage.getCartItemCount());
    }

    @Test
    void userShouldReturnToInventoryWhenContinuingShopping() {
        productListPage.addBackpackToCart();
        productListPage.openShoppingCart();

        shoppingCartPage.continueShopping();

        assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "User should return to the inventory page"
        );
    }
}
