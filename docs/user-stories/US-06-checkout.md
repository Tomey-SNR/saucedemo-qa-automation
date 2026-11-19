# US-06: Checkout

## User Story

As a user, I want to complete the checkout process so that I can purchase the products in my shopping cart.

## Acceptance Criteria

- A user can proceed from the shopping cart to checkout.
- The checkout form requests first name, last name, and postal code.
- Required customer information must be provided.
- Valid customer information allows the user to continue.
- The order overview displays the selected products.
- A user can complete the purchase.
- A successful purchase displays an order confirmation.

## Test Cases

| Test Case ID | Test Scenario | Expected Result | Status |
|---|---|---|---|
| TC-CHECKOUT-001 | Proceed to checkout | Checkout information form is displayed | PASS |
| TC-CHECKOUT-002 | Submit empty customer information | Validation error indicates that first name is required | PASS |
| TC-CHECKOUT-003 | Submit valid customer information | User advances to the order overview | PASS |
| TC-CHECKOUT-004 | Verify order summary | Selected product is displayed in the order overview | PASS |
| TC-CHECKOUT-005 | Complete purchase | Order confirmation is displayed with "Thank you for your order!" | PASS |

## Automation

- Language: Java 21
- Browser automation: Selenium WebDriver
- Test framework: JUnit 5
- Design pattern: Page Object Model
- Build tool: Maven

## Related Automation Classes

- `CheckoutTest.java`
- `CheckoutPage.java`
- `CheckoutOverviewPage.java`
- `CheckoutCompletePage.java`
- `ShoppingCartPage.java`
- `BaseTest.java`

## Test Execution Summary

Total test cases: 5

Passed: 5

Failed: 0