package com.codecool.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerInformation(
            String firstName,
            String lastName,
            String postalCode
    ) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(postalCodeField, postalCode);
    }

    public void continueCheckout() {
        click(continueButton);
    }

    public void cancelCheckout() {
        click(cancelButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isCheckoutFormDisplayed() {
        return isDisplayed(firstNameField)
                && isDisplayed(lastNameField)
                && isDisplayed(postalCodeField);
    }
}
