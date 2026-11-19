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