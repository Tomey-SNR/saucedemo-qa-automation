# US-02: User Logout

## User Story

As a logged-in user, I want to log out so that I can securely end my session.

## Acceptance Criteria

- A logged-in user can open the navigation menu.
- The navigation menu contains a logout option.
- Clicking logout redirects the user to the login page.
- A logged-out user cannot access the inventory page directly.

## Test Cases

| Test Case ID | Test Scenario | Expected Result | Status |
|---|---|---|---|
| TC-LOGOUT-001 | Logout from the inventory page | User is redirected to the login page | PASS |
| TC-LOGOUT-002 | Access inventory after logout | User cannot access the protected inventory page | PASS |

## Automation

- Language: Java 21
- Browser automation: Selenium WebDriver
- Test framework: JUnit 5
- Design pattern: Page Object Model
- Build tool: Maven

## Related Automation Classes

- `LogoutTest.java`
- `InventoryPage.java`
- `LoginPage.java`
- `BaseTest.java`

## Test Execution Summary

Total test cases: 2

Passed: 2

Failed: 0