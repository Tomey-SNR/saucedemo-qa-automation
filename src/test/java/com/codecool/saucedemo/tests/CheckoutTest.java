package com.codecool.saucedemo.tests;

import com.codecool.saucedemo.base.BaseTest;
import com.codecool.saucedemo.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";
    private static final String POSTAL_CODE = "12345";

    private static final String BACKPACK = "Sauce Labs Backpack";

    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage overviewPage;
    private CheckoutCompletePage completePage;

    @BeforeEach
    void prepareCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addBackpackToCart();
        productListPage.openShoppingCart();

        ShoppingCartPage shoppingCartPage =
                new ShoppingCartPage(driver);

        shoppingCartPage.proceedToCheckout();

        checkoutPage = new CheckoutPage(driver);
        overviewPage = new CheckoutOverviewPage(driver);
        completePage = new CheckoutCompletePage(driver);
    }

    @Test
    void userShouldProceedToCheckout() {
        assertTrue(checkoutPage.isCheckoutFormDisplayed());
    }

    @Test
    void userShouldNotContinueWithEmptyCustomerInformation() {
        checkoutPage.continueCheckout();

        assertTrue(
                checkoutPage.getErrorMessage().contains("First Name is required")
        );
    }

    @Test
    void userShouldProceedWithValidCustomerInformation() {
        checkoutPage.enterCustomerInformation(
                FIRST_NAME,
                LAST_NAME,
                POSTAL_CODE
        );

        checkoutPage.continueCheckout();

        assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"));
    }

    @Test
    void orderSummaryShouldDisplayCorrectProduct() {
        checkoutPage.enterCustomerInformation(
                FIRST_NAME,
                LAST_NAME,
                POSTAL_CODE
        );

        checkoutPage.continueCheckout();

        assertEquals(1, overviewPage.getProductCount());
        assertTrue(overviewPage.getProductNames().contains(BACKPACK));
    }

    @Test
    void userShouldCompletePurchaseSuccessfully() {
        checkoutPage.enterCustomerInformation(
                FIRST_NAME,
                LAST_NAME,
                POSTAL_CODE
        );

        checkoutPage.continueCheckout();
        overviewPage.finishPurchase();

        assertTrue(completePage.isOrderConfirmed());
        assertEquals(
                "Thank you for your order!",
                completePage.getConfirmationTitle()
        );
    }
}
