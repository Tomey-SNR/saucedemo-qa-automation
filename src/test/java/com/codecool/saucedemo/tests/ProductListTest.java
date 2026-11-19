package com.codecool.saucedemo.tests;

import com.codecool.saucedemo.base.BaseTest;
import com.codecool.saucedemo.pages.LoginPage;
import com.codecool.saucedemo.pages.ProductListPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductListTest extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    private ProductListPage productListPage;

    @BeforeEach
    void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        productListPage = new ProductListPage(driver);
    }

    @Test
    void allProductsShouldBeDisplayed() {
        assertEquals(
                6,
                productListPage.getProductCount(),
                "All six products should be displayed"
        );

        assertTrue(productListPage.areProductsDisplayed());
    }

    @Test
    void productsShouldBeSortedByNameAscending() {
        productListPage.sortBy("az");

        List<String> actualNames = productListPage.getProductNames();
        List<String> expectedNames = new ArrayList<>(actualNames);

        Collections.sort(expectedNames);

        assertEquals(expectedNames, actualNames);
    }

    @Test
    void productsShouldBeSortedByPriceAscending() {
        productListPage.sortBy("lohi");

        List<Double> prices = productListPage.getProductPrices();
        List<Double> expectedPrices = new ArrayList<>(prices);

        Collections.sort(expectedPrices);

        assertEquals(expectedPrices, prices);
    }

    @Test
    void productsShouldBeSortedByPriceDescending() {
        productListPage.sortBy("hilo");

        List<Double> prices = productListPage.getProductPrices();
        List<Double> expectedPrices = new ArrayList<>(prices);

        expectedPrices.sort(Collections.reverseOrder());

        assertEquals(expectedPrices, prices);
    }
}
