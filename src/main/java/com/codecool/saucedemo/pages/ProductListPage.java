package com.codecool.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductListPage extends BasePage {

    private final By productItems = By.className("inventory_item");
    private final By productNames = By.className("inventory_item_name");
    private final By productPrices = By.className("inventory_item_price");
    private final By sortDropdown = By.className("product_sort_container");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By addBikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By shoppingCartLink = By.className("shopping_cart_link");

    public ProductListPage(WebDriver driver) {
        super(driver);
        waitForVisibility(By.className("inventory_list"));
    }

    public int getProductCount() {
        return driver.findElements(productItems).size();
    }

    public List<String> getProductNames() {
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getProductPrices() {
        return driver.findElements(productPrices)
                .stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }

    public void sortBy(String option) {
        Select select = new Select(waitForVisibility(sortDropdown));
        select.selectByValue(option);
    }

    public boolean areProductsDisplayed() {
        return getProductCount() > 0;
    }

    public void openProduct(String name) {
        WebElement product = driver.findElements(productNames)
                .stream()
                .filter(element -> element.getText().trim().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Product not found: " + name
                ));

        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }

    public void addBackpackToCart() {
        click(addBackpackButton);
    }

    public void addBikeLightToCart() {
        click(addBikeLightButton);
    }

    public void openShoppingCart() {
        click(shoppingCartLink);
    }
}
