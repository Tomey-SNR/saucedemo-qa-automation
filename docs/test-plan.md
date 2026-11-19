# SauceDemo QA Automation — Test Plan

## 1. Project Overview

**Application:** SauceDemo  
**Application URL:** https://www.saucedemo.com/  
**Testing type:** Web UI functional testing and test automation  
**Testing approach:** Risk-based functional testing with automated regression tests

The purpose of this project is to evaluate the SauceDemo webshop by testing its main user workflows and automating selected test cases.

## 2. Testing Objectives

- Verify the main webshop functionality.
- Identify defects and unexpected application behavior.
- Validate positive and negative user scenarios.
- Automate repeatable functional test cases.
- Execute automated tests through a CI pipeline.
- Provide evidence-based feedback about release readiness.

## 3. Scope of Testing

The following six user stories are included:

| ID | User Story | Testing Scope |
|---|---|---|
| US-01 | Login | Valid and invalid credentials, required fields |
| US-02 | Logout | Logout functionality and access after logout |
| US-03 | Product List | Product visibility and sorting |
| US-04 | Product Details | Product name, description, price and image |
| US-05 | Shopping Cart | Adding, viewing and removing products |
| US-06 | Checkout | Customer information, order overview and purchase confirmation |

## 4. Test Approach

### Functional Testing

Verify that the application behaves according to the documented user stories and acceptance criteria.

### Positive Testing

Verify that valid user actions produce the expected results.

### Negative Testing

Verify that invalid credentials and missing required information are handled appropriately.

### Regression Testing

Re-execute automated test cases after changes to verify that existing functionality continues to work.

### Automated Testing

Use Selenium WebDriver to interact with the application and JUnit 5 to execute and validate test scenarios.

## 5. Test Environment

| Component | Technology |
|---|---|
| Operating System (local) | Windows 11 |
| Programming Language | Java 21 |
| Browser | Google Chrome |
| Browser Automation | Selenium WebDriver 4.51.0 |
| Test Framework | JUnit 5.12.2 |
| Build Tool | Maven |
| IDE | IntelliJ IDEA |
| Version Control | Git and GitHub |
| CI/CD | GitHub Actions |
| CI Operating System | Ubuntu latest |

## 6. Test Data

The project uses the publicly available SauceDemo demonstration application and its predefined test accounts.

The primary automated workflows use the standard user account.

Invalid usernames and passwords are used for negative login scenarios.

No private user credentials are stored in the repository.

## 7. Test Design and Architecture

The automation framework follows the Page Object Model (POM).

Main components:

- **BaseTest:** Common browser setup and teardown.
- **DriverFactory:** WebDriver creation and browser configuration.
- **BasePage:** Shared page interaction methods and explicit waits.
- **Page Objects:** Encapsulate page elements and user interactions.
- **Test Classes:** Contain test scenarios and assertions.

Each test creates its own browser session through the common test setup.

## 8. Entry Criteria

Testing can begin when:

- The application is accessible.
- The test automation project is configured.
- Required dependencies are available.
- The browser and WebDriver can be initialized.
- Test cases and expected results are documented.

## 9. Exit Criteria

The planned automated test execution is considered complete when:

- All implemented automated test cases have been executed.
- Test results are recorded.
- Critical test failures have been investigated.
- The CI pipeline completes successfully.
- Test execution and release assessment documents are prepared.

Passing automated tests alone does not guarantee that every application risk has been eliminated.

## 10. Known Limitations

- The automated suite focuses on the six documented user stories.
- The primary workflows use the standard demo user.
- Not all predefined SauceDemo user profiles have been evaluated.
- Performance, accessibility, security and API testing are outside the current automated scope.
- Manual exploratory testing findings must be documented separately.

## 11. Deliverables

- Six documented user stories.
- Automated Selenium test suite.
- Page Object Model framework.
- GitHub Actions CI workflow.
- Test execution report.
- Release assessment.
- Bug reports for confirmed application defects, if discovered.