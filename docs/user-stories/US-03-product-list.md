# US-03: Product List

## User Story

As a logged-in user, I want to view the available products and sort them so that I can find products more easily.

## Acceptance Criteria

- The inventory page displays the available products.
- All six products are displayed.
- Products can be sorted alphabetically in ascending order.
- Products can be sorted by price in ascending order.
- Products can be sorted by price in descending order.

## Test Cases

| Test Case ID | Test Scenario | Expected Result | Status |
|---|---|---|---|
| TC-PRODUCT-LIST-001 | Display all products | All six products are displayed | PASS |
| TC-PRODUCT-LIST-002 | Sort products by name ascending | Products are displayed alphabetically | PASS |
| TC-PRODUCT-LIST-003 | Sort products by price ascending | Products are displayed from lowest to highest price | PASS |
| TC-PRODUCT-LIST-004 | Sort products by price descending | Products are displayed from highest to lowest price | PASS |

## Automation

- Language: Java 21
- Browser automation: Selenium WebDriver
- Test framework: JUnit 5
- Design pattern: Page Object Model
- Build tool: Maven

## Related Automation Classes

- `ProductListTest.java`
- `ProductListPage.java`
- `LoginPage.java`
- `BaseTest.java`

## Test Execution Summary

Total test cases: 4

Passed: 4

Failed: 0