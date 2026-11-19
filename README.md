# SauceDemo QA Automation

[![SauceDemo QA Automation CI](https://github.com/Tomey-SNR/saucedemo-qa-automation/actions/workflows/ci.yml/badge.svg)](https://github.com/Tomey-SNR/saucedemo-qa-automation/actions/workflows/ci.yml)

Automated functional testing of the [SauceDemo](https://www.saucedemo.com/) webshop using Java, Selenium WebDriver, JUnit 5 and Maven.

## Project Overview

This project evaluates the main user workflows of the SauceDemo application through manual testing and automated browser tests.

The automation framework follows the Page Object Model (POM) design pattern and uses GitHub Actions for continuous integration.

## Testing Scope

The project covers six user stories:

| ID | User Story | Automated Tests |
|---|---|---:|
| US-01 | Login | 5 |
| US-02 | Logout | 2 |
| US-03 | Product List | 4 |
| US-04 | Product Details | 4 |
| US-05 | Shopping Cart | 5 |
| US-06 | Checkout | 5 |
| **Total** | **6 user stories** | **25** |

## Technologies

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Selenium WebDriver 4.51.0 | Browser automation |
| JUnit 5.12.2 | Test framework |
| Maven | Build and dependency management |
| Google Chrome | Test browser |
| Git and GitHub | Version control |
| GitHub Actions | Continuous integration |
| IntelliJ IDEA | Development environment |

## Project Structure

```text
saucedemo-qa-automation/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── docs/
│   ├── user-stories/
│   │   ├── US-01-login.md
│   │   ├── US-02-logout.md
│   │   ├── US-03-product-list.md
│   │   ├── US-04-product-details.md
│   │   ├── US-05-shopping-cart.md
│   │   └── US-06-checkout.md
│   │
│   ├── test-plan.md
│   ├── test-execution-report.md
│   └── release-assessment.md
│
├── src/
│   ├── main/
│   │   └── java/com/codecool/saucedemo/
│   │       ├── config/
│   │       │   ├── DriverFactory.java
│   │       │   └── TestConfig.java
│   │       │
│   │       └── pages/
│   │           ├── BasePage.java
│   │           ├── LoginPage.java
│   │           ├── InventoryPage.java
│   │           ├── ProductListPage.java
│   │           ├── ProductDetailsPage.java
│   │           ├── ShoppingCartPage.java
│   │           ├── CheckoutPage.java
│   │           ├── CheckoutOverviewPage.java
│   │           └── CheckoutCompletePage.java
│   │
│   └── test/
│       └── java/com/codecool/saucedemo/
│           ├── base/
│           │   └── BaseTest.java
│           │
│           └── tests/
│               ├── LoginTest.java
│               ├── LogoutTest.java
│               ├── ProductListTest.java
│               ├── ProductDetailsTest.java
│               ├── ShoppingCartTest.java
│               └── CheckoutTest.java
│
├── .gitignore
├── pom.xml
└── README.md
```

## Prerequisites

Install the following:

- Java Development Kit (JDK) 21
- Apache Maven 3.9 or newer
- Google Chrome
- Git

Verify the installations:

```bash
java -version
mvn -version
git --version
```

## Installation

Clone the repository:

```bash
git clone https://github.com/Tomey-SNR/saucedemo-qa-automation.git
```

Navigate to the project directory:

```bash
cd saucedemo-qa-automation
```

Install dependencies and compile the project:

```bash
mvn clean compile
```

## Running Automated Tests

Execute the complete test suite:

```bash
mvn clean test
```

Maven Surefire generates test reports in:

```text
target/surefire-reports/
```

## Browser Execution Modes

### Normal Mode

When running tests locally, Chrome opens visibly so browser interactions can be observed.

### Headless Mode

For CI execution, Chrome runs without a visible browser window.

To enable headless mode locally using PowerShell:

```powershell
$env:CI = "true"
mvn clean test
Remove-Item Env:CI
```

## Continuous Integration

GitHub Actions automatically executes the automated test suite.

The workflow is triggered by:

- Pushes to `main`.
- Pushes to feature branches.
- Pull requests targeting `main`.

The pipeline performs these steps:

1. Checks out the repository.
2. Sets up Java 21.
3. Sets up Chrome.
4. Executes Maven tests in headless mode.
5. Uploads Surefire test reports.

Workflow configuration:

```text
.github/workflows/ci.yml
```

## Test Results

Latest verified local test execution:

| Metric | Result |
|---|---:|
| Tests executed | 25 |
| Passed | 25 |
| Failed | 0 |
| Errors | 0 |
| Skipped | 0 |
| Pass rate | 100% |

GitHub Actions push and pull request checks also passed after the latest synchronization fixes.

See [Test Execution Report](docs/test-execution-report.md) for execution details.

## QA Documentation

| Document | Description |
|---|---|
| [Test Plan](docs/test-plan.md) | Testing objectives, scope, approach and environment |
| [US-01: Login](docs/user-stories/US-01-login.md) | Login scenarios |
| [US-02: Logout](docs/user-stories/US-02-logout.md) | Logout scenarios |
| [US-03: Product List](docs/user-stories/US-03-product-list.md) | Product listing and sorting |
| [US-04: Product Details](docs/user-stories/US-04-product-details.md) | Product information |
| [US-05: Shopping Cart](docs/user-stories/US-05-shopping-cart.md) | Cart operations |
| [US-06: Checkout](docs/user-stories/US-06-checkout.md) | Checkout workflow |
| [Test Execution Report](docs/test-execution-report.md) | Automated execution results |
| [Release Assessment](docs/release-assessment.md) | Release recommendation and remaining risks |

## Design Approach

The project uses the Page Object Model to separate page-specific interactions from test logic.

Key components:

- **DriverFactory:** Creates and configures ChromeDriver.
- **BaseTest:** Handles browser setup and teardown.
- **BasePage:** Provides reusable Selenium interaction methods and explicit waits.
- **Page Objects:** Represent application pages and encapsulate their elements and actions.
- **Test Classes:** Contain test scenarios and assertions.

Each test receives a fresh browser session to support test isolation.

## Limitations

The current automated suite focuses on the six documented user stories.

Additional testing is recommended for:

- Other predefined SauceDemo user profiles.
- More extensive checkout price and tax calculations.
- Performance, accessibility, security and API behavior.
- Additional manual exploratory scenarios.

## Release Assessment

The 25 automated test cases passed, and the CI pipeline completed successfully.

However, further exploratory and functional testing is recommended before an unconditional production release recommendation.

See [Release Assessment](docs/release-assessment.md) for details.