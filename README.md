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

A. Category: Behavioral
--------------

1. Pattern Name: Template Method Pattern

Purpose: Define a fixed test flow while allowing subclasses to change specific steps

Uses:

- Standardizing setup/teardown in TestNG/JUnit base classes

- UI/API hybrid frameworks with fixed flow but variable execution

- Regression templates with different verification logic

Example: runTest() defines setup → executeTest → verify → teardown; subclasses override only executeTest() & verify()

--------------

2. Pattern Name: Strategy Pattern

Purpose: Select an algorithm/implementation at runtime

Uses:

- Switching between Chrome, Firefox, Edge drivers

- Choosing between API and UI test execution

- Selecting data parsing logic (CSV, JSON, Excel)

Example: DriverStrategy interface with ChromeDriverStrategy, FirefoxDriverStrategy; DriverManager picks based on config

--------------

3. Pattern Name: Observer Pattern

Purpose: Notify multiple listeners when a subject changes

Uses:

- Reporting updates to multiple dashboards

- Logging test events to console, file, and Allure at once

- Parallel test status notifications

Example: Test execution triggers events → listeners send logs, screenshots, and metrics simultaneously

--------------

4. Pattern Name: Chain of Responsibility Pattern
   
Purpose: Pass a request through a chain of handlers until one processes it

Uses:

- Chained validators for UI fields, API response checks, and preconditions

- Sequential rule-based validations before test execution

- Conditional request filtering in API automation
  
Example: ValidationHandler chain → UIValidator → APIValidator → DataValidator → stops when one fails

--------------

B. Category: Creational
--------------

1. Pattern: Singleton Pattern

Definition: Ensure only one instance of a class exists

Uses:

- Managing single WebDriver instance per test thread

- Maintaining a single database connection

- Centralized config manager

Example: DriverManager.getInstance() always returns same driver for a thread

--------------

2. Pattern: Factory Pattern

Definition: Create objects without exposing creation logic

Applications:

- Generating driver instances based on browser type

- Creating API request builders for different HTTP methods

- Data provider objects from different sources

Example: DriverFactory.getDriver("chrome") returns Chrome WebDriver

--------------

3. Pattern Name: Builder Pattern

Purpose: Construct complex objects step-by-step without directly instantiating them

Uses:

- Building complex API requests (JSON/XML) in RestAssured

- Creating test data objects with multiple optional fields

- Configuring WebDriver options fluently
  
Example: UserBuilder.setName("John").setAge(30).setRole("Admin").build()

--------------

C. Category: Structural
--------------

1. Pattern: Page Object Model (POM)

Definition: Encapsulate UI elements and actions into objects

Applications:

- Maintaining reusable UI components

- Reducing code duplication in Selenium scripts

- Easier maintenance when UI changes
  
Example: LoginPage.login(username, password) instead of locating elements in every test

--------------

2. Pattern: Data-Driven Framework (Integration)

Definition: Separate test logic from test data so tests remain unchanged when data changes.

Applications:

- Running same test with multiple datasets

- Externalizing test data (Excel, CSV, JSON, DB)

- Easy parameterization for CI pipelines: Running the same UI/API tests with multiple datasets
  
Example: In TestNG, use @DataProvider to read data from Excel, CSV, JSON, or DB. One test method executes multiple times with different input sets.

--------------

3. Pattern: Decorator Pattern
   
Definition: Dynamically add responsibilities to objects

Applications:

- Adding logging around WebDriver actions

- Wrapping API requests with retry logic

- Adding wait mechanisms to existing page methods
  
Example: LoggingDriver wraps WebDriver methods and logs before/after action

--------------

4. Pattern Name: Facade Pattern
   
Purpose: Provide a simplified interface to complex subsystems

Uses:

- Single class to trigger Selenium + API + DB checks

- Unified test launcher for multi-tool execution (Selenium, RestAssured, JDBC)

- Wrapping multiple report generators behind one call
  
Example: TestFacade.runFullTest() internally calls UI test, API test, DB verification

--------------

