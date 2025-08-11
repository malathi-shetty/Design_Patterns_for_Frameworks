# Design_Patterns_for_Frameworks

Overview:
This project demonstrates Java + Maven implementations of key design patterns tailored for SDET and Test Automation.
Each pattern is applied to real-world testing scenarios — from Selenium UI tests to API automation — ensuring the framework is scalable, reusable, and maintainable.

Patterns Implemented:
| Category       | Pattern Name            | Example SDET Use Case                             |
| -------------- | ----------------------- | ------------------------------------------------- |
| **Creational** | Singleton Pattern       | Centralized WebDriver management                  |
|                | Builder Pattern         | Flexible test data creation                       |
|                | Factory Method Pattern  | Cross-browser WebDriver creation                  |
| **Structural** | Page Object Pattern     | Encapsulating UI interactions                     |
|                | Facade Pattern          | Simplified high-level test flows                  |
| **Behavioral** | Strategy Pattern        | Switchable login & verification strategies        |
|                | Observer Pattern        | Test event logging & reporting                    |
|                | Chain of Responsibility | Chained validators for UI, API, and preconditions |
|                | Template Method Pattern | Standardized test flow via base test classes      |

Highlights

Category: Behavioral
Pattern Name: Template Method Pattern
Purpose: Define a fixed test flow while allowing subclasses to change specific steps
SDET Uses:

Standardizing setup/teardown in TestNG/JUnit base classes

UI/API hybrid frameworks with fixed flow but variable execution

Regression templates with different verification logic
Example: runTest() defines setup → executeTest → verify → teardown; subclasses override only executeTest() & verify()

Category: Behavioral
Pattern Name: Strategy Pattern
Purpose: Select an algorithm/implementation at runtime
SDET Uses:

Switching between Chrome, Firefox, Edge drivers

Choosing between API and UI test execution

Selecting data parsing logic (CSV, JSON, Excel)
Example: DriverStrategy interface with ChromeDriverStrategy, FirefoxDriverStrategy; DriverManager picks based on config

Category: Behavioral
Pattern Name: Observer Pattern
Purpose: Notify multiple listeners when a subject changes
SDET Uses:

Reporting updates to multiple dashboards

Logging test events to console, file, and Allure at once

Parallel test status notifications
Example: Test execution triggers events → listeners send logs, screenshots, and metrics simultaneously

Category: Creational
Pattern: Singleton Pattern
Definition: Ensure only one instance of a class exists
Applications:

Managing single WebDriver instance per test thread

Maintaining a single database connection

Centralized config manager
Example: DriverManager.getInstance() always returns same driver for a thread

Category: Creational
Pattern: Factory Pattern
Definition: Create objects without exposing creation logic
Applications:

Generating driver instances based on browser type

Creating API request builders for different HTTP methods

Data provider objects from different sources
Example: DriverFactory.getDriver("chrome") returns Chrome WebDriver

Category: Structural
Pattern: Page Object Model (POM)
Definition: Encapsulate UI elements and actions into objects
Applications:

Maintaining reusable UI components

Reducing code duplication in Selenium scripts

Easier maintenance when UI changes
Example: LoginPage.login(username, password) instead of locating elements in every test

Category: Structural
Pattern: Data-Driven Framework (Integration)
Definition: Separate test logic from test data
Applications:

Running same test with multiple datasets

Externalizing test data (Excel, CSV, JSON, DB)

Easy parameterization for CI pipelines
Example: @DataProvider in TestNG reads from Excel, test executes for each row

Category: Structural
Pattern: Decorator Pattern
Definition: Dynamically add responsibilities to objects
Applications:

Adding logging around WebDriver actions

Wrapping API requests with retry logic

Adding wait mechanisms to existing page methods
Example: LoggingDriver wraps WebDriver methods and logs before/after action

Category: Structural
Pattern: Page Object Model (POM)
Purpose: Encapsulate UI elements and actions into objects
Applications:

Maintaining reusable UI components

Reducing code duplication in Selenium scripts

Easier maintenance when UI changes
Example: LoginPage.login(username, password) instead of locating elements in every test

Category: Structural
Pattern: Data-Driven Framework (Integration)
Purpose: Separate test logic from test data
Applications:

Running same test with multiple datasets

Externalizing test data (Excel, CSV, JSON, DB)

Easy parameterization for CI pipelines
Example: @DataProvider in TestNG reads from Excel, test executes for each row

Category: Structural
Pattern: Decorator Pattern
Purpose: Dynamically add responsibilities to objects
Applications:

Adding logging around WebDriver actions

Wrapping API requests with retry logic

Adding wait mechanisms to existing page methods
Example: LoggingDriver wraps WebDriver methods and logs before/after action

Category: Creational
Pattern: Singleton Pattern
Purpose: Ensure only one instance of a class exists
Applications:

Managing single WebDriver instance per test thread

Maintaining a single database connection

Centralized config manager
Example: DriverManager.getInstance() always returns same driver for a thread

Category: Creational
Pattern: Factory Pattern
Purpose: Create objects without exposing creation logic
Applications:

Generating driver instances based on browser type

Creating API request builders for different HTTP methods

Data provider objects from different sources
Example: DriverFactory.getDriver("chrome") returns Chrome WebDriver
