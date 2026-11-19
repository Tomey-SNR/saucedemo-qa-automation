package com.codecool.saucedemo.tests;

import com.codecool.saucedemo.base.BaseTest;
import com.codecool.saucedemo.pages.LoginPage;
import com.codecool.saucedemo.pages.ProductDetailsPage;
import com.codecool.saucedemo.pages.ProductListPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDetailsTest extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Backpack";

    private ProductDetailsPage productDetailsPage;

    @BeforeEach
    void openProductDetails() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.openProduct(PRODUCT_NAME);

        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test
    void productDetailsShouldBeDisplayed() {
        assertEquals(
                PRODUCT_NAME,
                productDetailsPage.getProductName()
        );

        assertTrue(productDetailsPage.isProductImageDisplayed());
    }

    @Test
    void productNameShouldBeCorrect() {
        assertEquals(
                PRODUCT_NAME,
                productDetailsPage.getProductName()
        );
    }

    @Test
    void productDescriptionShouldBeDisplayed() {
        assertFalse(
                productDetailsPage.getProductDescription().isBlank(),
                "Product description should not be empty"
        );
    }

    @Test
    void productPriceShouldBeDisplayed() {
        assertTrue(
                productDetailsPage.getProductPrice().startsWith("$"),
                "Product price should start with a dollar sign"
        );
    }
}
