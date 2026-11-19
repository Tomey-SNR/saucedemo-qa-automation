package com.codecool.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    private final By cartItems = By.className("cart_item");
    private final By cartItemNames = By.className("inventory_item_name");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By removeButtons = By.cssSelector("[data-test^='remove-']");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCartItemNames() {
        return driver.findElements(cartItemNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public String getCartBadgeCount() {
        return waitForVisibility(cartBadge).getText();
    }

    public void removeFirstProduct() {
        waitForClickability(removeButtons).click();
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }

    public boolean isProductDisplayed(String productName) {
        return getCartItemNames().contains(productName);
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }
}
