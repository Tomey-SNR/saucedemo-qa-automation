package com.codecool.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By confirmationTitle =
            By.className("complete-header");

    private final By confirmationMessage =
            By.className("complete-text");

    private final By backHomeButton =
            By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationTitle() {
        return getText(confirmationTitle);
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }

    public void backToProducts() {
        click(backHomeButton);
    }

    public boolean isOrderConfirmed() {
        return isDisplayed(confirmationTitle);
    }
}
