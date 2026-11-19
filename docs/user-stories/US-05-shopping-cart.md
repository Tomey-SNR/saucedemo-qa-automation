# US-05: Shopping Cart

## User Story

As a logged-in user, I want to add and remove products from my shopping cart so that I can manage the products I intend to purchase.

## Acceptance Criteria

- A user can add a product to the shopping cart.
- A user can add multiple products to the shopping cart.
- Added products are displayed in the shopping cart.
- The shopping cart displays the correct number of products.
- A user can remove a product from the shopping cart.
- A user can continue shopping after opening the cart.

## Test Cases

| Test Case ID | Test Scenario | Expected Result | Status |
|---|---|---|---|
| TC-CART-001 | Add a product to the cart | Product is added successfully | PASS |
| TC-CART-002 | Add multiple products | All selected products are added | PASS |
| TC-CART-003 | Verify products in cart | Selected products are displayed in the cart | PASS |
| TC-CART-004 | Remove a product | Selected product is removed from the cart | PASS |
| TC-CART-005 | Continue shopping | User returns to the inventory page | PASS |

## Automation

- Language: Java 21
- Browser automation: Selenium WebDriver
- Test framework: JUnit 5
- Design pattern: Page Object Model
- Build tool: Maven

## Related Automation Classes

- `ShoppingCartTest.java`
- `ShoppingCartPage.java`
- `ProductListPage.java`
- `BaseTest.java`

## Test Execution Summary

Total test cases: 5

Passed: 5

Failed: 0