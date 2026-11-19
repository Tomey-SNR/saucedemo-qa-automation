# SauceDemo QA Automation — Test Execution Report

## 1. Execution Overview

**Application:** SauceDemo  
**Application URL:** https://www.saucedemo.com/  
**Project:** SauceDemo QA Automation  
**Testing Framework:** Selenium WebDriver and JUnit 5  
**Build Tool:** Maven  
**Execution Date:** 19 November 2026

The purpose of this report is to summarize the execution results of the automated functional test suite.

## 2. Test Execution Summary

| Metric | Result |
|---|---:|
| Total test cases | 25 |
| Passed | 25 |
| Failed | 0 |
| Errors | 0 |
| Skipped | 0 |
| Pass rate | 100% |

**Overall result: PASS**

## 3. Results by User Story

| User Story | Test Cases | Passed | Failed |
|---|---:|---:|---:|
| US-01: Login | 5 | 5 | 0 |
| US-02: Logout | 2 | 2 | 0 |
| US-03: Product List | 4 | 4 | 0 |
| US-04: Product Details | 4 | 4 | 0 |
| US-05: Shopping Cart | 5 | 5 | 0 |
| US-06: Checkout | 5 | 5 | 0 |
| **Total** | **25** | **25** | **0** |

## 4. Local Test Execution

The automated suite was executed locally using Maven.

Command:

```bash
mvn clean test
```

Result:

```text
Tests run: 25, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

### Headless Execution

The suite was also executed locally in headless Chrome mode.

Command:

```powershell
$env:CI = "true"
mvn clean test
Remove-Item Env:CI
```

Result:

```text
Tests run: 25, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

## 5. CI/CD Execution

The project uses GitHub Actions to execute automated tests.

The workflow is triggered by:

- Pushes to the main branch.
- Pushes to feature branches.
- Pull requests targeting the main branch.

The workflow performs the following steps:

1. Checks out the repository.
2. Sets up Java 21.
3. Sets up Chrome.
4. Executes Maven tests in headless mode.
5. Uploads Maven Surefire test reports.

### CI Results

The final CI execution completed successfully for both:

- Push event.
- Pull request event.

Both GitHub Actions checks passed.

## 6. Issues Encountered During Automation

### Inventory Synchronization Issue

During the initial CI execution, two product-related tests failed:

- `ProductListTest.allProductsShouldBeDisplayed`
- `ProductDetailsTest.openProductDetails`

The inventory page was not yet visible when the tests attempted to locate products.

**Root cause:** The ProductListPage constructor did not wait for the inventory list to become visible.

**Resolution:** Added an explicit wait for the `inventory_list` element using the existing BasePage wait functionality.

**Verification:** All 25 tests passed locally, and both GitHub Actions checks passed after the fix.

This was an automation synchronization issue, not a confirmed application defect.

## 7. Final Results

The final automated test execution achieved:

- 25 passing automated tests.
- Zero failures.
- Zero errors.
- Successful local headless execution.
- Successful GitHub Actions push and pull request checks.

## 8. Conclusion

The implemented automated regression suite successfully verifies the selected functionality across all six documented user stories.

All 25 automated test cases passed during the final local execution, and the CI pipeline completed successfully.

The results provide positive evidence for the tested workflows. However, they do not establish complete application quality or guarantee release readiness outside the tested scope.

See `release-assessment.md` for the release recommendation.