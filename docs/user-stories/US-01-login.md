# US-01: User Login

## User Story

As a user, I want to log in with my credentials so that I can access the webshop.

## Acceptance Criteria

- A user can log in with valid credentials.
- A user cannot log in with an incorrect password.
- A user cannot log in with an incorrect username.
- The username field is required.
- The password field is required.
- Successful login redirects the user to the inventory page.
- Unsuccessful login displays an appropriate error message.

## Test Cases

| Test Case ID | Test Scenario | Expected Result | Status |
|---|---|---|---|
| TC-LOGIN-001 | Login with valid credentials | User is redirected to the inventory page | PASS |
| TC-LOGIN-002 | Login with invalid password | Error message is displayed | PASS |
| TC-LOGIN-003 | Login with invalid username | Error message is displayed | PASS |
| TC-LOGIN-004 | Login with empty username | Validation error is displayed | PASS |
| TC-LOGIN-005 | Login with empty password | Validation error is displayed | PASS |

## Automation

- Language: Java 21
- Browser automation: Selenium WebDriver
- Test framework: JUnit 5
- Design pattern: Page Object Model
- Build tool: Maven

## Related Automation Classes

- `LoginTest.java`
- `LoginPage.java`
- `BaseTest.java`

## Test Execution Summary

Total test cases: 5

Passed: 5

Failed: 0