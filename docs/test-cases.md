# Test Cases

## User Story 1: Login

**As a User, I want to log in so that I have access to features that require identification.**

### TC-LOGIN-001: Login with valid credentials

- **Priority:** High
- **Type:** Positive
- **Precondition:** User is on the login page.
- **Test data:** `standard_user` / `secret_sauce`
- **Steps:**
    1. Enter a valid username.
    2. Enter a valid password.
    3. Click the Login button.
- **Expected result:** User is successfully authenticated and redirected to the inventory page.

### TC-LOGIN-002: Login with an invalid password

- **Priority:** High
- **Type:** Negative
- **Precondition:** User is on the login page.
- **Test data:** `standard_user` / `wrong_password`
- **Steps:**
    1. Enter a valid username.
    2. Enter an incorrect password.
    3. Click the Login button.
- **Expected result:** Login is rejected and an appropriate error message is displayed.

### TC-LOGIN-003: Login with an invalid username

- **Priority:** High
- **Type:** Negative
- **Precondition:** User is on the login page.
- **Test data:** `wrong_user` / `secret_sauce`
- **Steps:**
    1. Enter an incorrect username.
    2. Enter a valid password.
    3. Click the Login button.
- **Expected result:** Login is rejected and an appropriate error message is displayed.

### TC-LOGIN-004: Login with an empty username

- **Priority:** Medium
- **Type:** Negative
- **Precondition:** User is on the login page.
- **Test data:** Empty username / `secret_sauce`
- **Steps:**
    1. Leave the username field empty.
    2. Enter a valid password.
    3. Click the Login button.
- **Expected result:** Login is rejected and a username-required error message is displayed.

### TC-LOGIN-005: Login with an empty password

- **Priority:** Medium
- **Type:** Negative
- **Precondition:** User is on the login page.
- **Test data:** `standard_user` / Empty password
- **Steps:**
    1. Enter a valid username.
    2. Leave the password field empty.
    3. Click the Login button.
- **Expected result:** Login is rejected and a password-required error message is displayed.

## Execution Summary

| Metric | Result |
|---|---:|
| Test cases | 5 |
| Automated tests | 5 |
| Passed | 5 |
| Failed | 0 |
| Status | Passed |

**Execution environment:** Java 21, Selenium WebDriver, JUnit 5, Maven, Chrome.

## User Story 2: Logout

**As a User, I want to log out so that I can securely end my session.**

### TC-LOGOUT-001: Logout from the inventory page

- **Priority:** High
- **Type:** Positive
- **Precondition:** User is successfully logged in.
- **Steps:**
  1. Open the navigation menu.
  2. Click Logout.
- **Expected result:** User is redirected to the login page.

### TC-LOGOUT-002: Access inventory after logout

- **Priority:** High
- **Type:** Negative
- **Precondition:** User has successfully logged in and then logged out.
- **Steps:**
  1. Log in with valid credentials.
  2. Open the navigation menu.
  3. Click Logout.
  4. Navigate directly to the inventory URL.
- **Expected result:** User cannot access the inventory page without logging in and is redirected to the login page.

### Execution Summary

| Metric | Result |
|---|---:|
| Test cases | 2 |
| Automated tests | 2 |
| Passed | 2 |
| Failed | 0 |
| Status | Passed |

## User Story 3: Product List

**As a User, I want to see the available products so that I can choose products to purchase.**

### TC-PRODUCT-001: Display all products

- **Priority:** High
- **Type:** Positive
- **Precondition:** User is logged in.
- **Steps:**
  1. Open the inventory page.
  2. Inspect the displayed products.
- **Expected result:** All six products are displayed.

### TC-PRODUCT-002: Sort products by name (A–Z)

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** User is logged in and the inventory page is displayed.
- **Steps:**
  1. Select Name (A to Z) from the sorting dropdown.
- **Expected result:** Products are displayed in alphabetical order.

### TC-PRODUCT-003: Sort products by price (low to high)

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** User is logged in and the inventory page is displayed.
- **Steps:**
  1. Select Price (low to high) from the sorting dropdown.
- **Expected result:** Products are displayed in ascending price order.

### TC-PRODUCT-004: Sort products by price (high to low)

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** User is logged in and the inventory page is displayed.
- **Steps:**
  1. Select Price (high to low) from the sorting dropdown.
- **Expected result:** Products are displayed in descending price order.

### Execution Summary

| Metric | Result |
|---|---:|
| Test cases | 4 |
| Automated tests | 4 |
| Passed | 4 |
| Failed | 0 |
| Status | Passed |

## User Story 4: Product Details

**As a User, I want to view product details so that I can make an informed purchasing decision.**

### TC-DETAIL-001: Open product details

- **Priority:** High
- **Type:** Positive
- **Precondition:** User is logged in and the inventory page is displayed.
- **Steps:**
  1. Click Sauce Labs Backpack.
- **Expected result:** The product details page is displayed with the correct product name and image.

### TC-DETAIL-002: Verify product name

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** Product details page is displayed.
- **Steps:**
  1. Inspect the product name.
- **Expected result:** The product name is Sauce Labs Backpack.

### TC-DETAIL-003: Verify product description

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** Product details page is displayed.
- **Steps:**
  1. Inspect the product description.
- **Expected result:** The product description is not empty.

### TC-DETAIL-004: Verify product price

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** Product details page is displayed.
- **Steps:**
  1. Inspect the product price.
- **Expected result:** The product price is displayed and starts with a dollar sign.

### Execution Summary

| Metric | Result |
|---|---:|
| Test cases | 4 |
| Automated tests | 4 |
| Passed | 4 |
| Failed | 0 |
| Status | Passed |

## User Story 5: Shopping Cart

**As a User, I want to manage my shopping cart so that I can review and modify my selected products before checkout.**

### TC-CART-001: Add a product to the cart

- **Priority:** High
- **Type:** Positive
- **Precondition:** User is logged in.
- **Steps:**
  1. Add Sauce Labs Backpack to the cart.
  2. Open the shopping cart.
- **Expected result:** Sauce Labs Backpack is displayed in the cart and the cart contains one item.

### TC-CART-002: Add multiple products to the cart

- **Priority:** High
- **Type:** Positive
- **Precondition:** User is logged in.
- **Steps:**
  1. Add Sauce Labs Backpack.
  2. Add Sauce Labs Bike Light.
  3. Open the shopping cart.
- **Expected result:** Both products are displayed in the cart.

### TC-CART-003: View added products

- **Priority:** High
- **Type:** Positive
- **Precondition:** User has added products to the cart.
- **Steps:**
  1. Open the shopping cart.
- **Expected result:** All added products are displayed.

### TC-CART-004: Remove a product from the cart

- **Priority:** High
- **Type:** Positive
- **Precondition:** User has added at least two products.
- **Steps:**
  1. Open the shopping cart.
  2. Remove the first product.
- **Expected result:** The removed product disappears and one product remains.

### TC-CART-005: Continue shopping

- **Priority:** Medium
- **Type:** Positive
- **Precondition:** User is viewing the shopping cart.
- **Steps:**
  1. Click Continue Shopping.
- **Expected result:** User returns to the inventory page.

### Execution Summary

| Metric | Result |
|---|---:|
| Test cases | 5 |
| Automated tests | 5 |
| Passed | 5 |
| Failed | 0 |
| Status | Passed |