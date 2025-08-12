# Design_Patterns_for_Frameworks

`Overview:`
- This project demonstrates Java + Maven implementations of key design patterns tailored for Test Automation.
- Each pattern is applied to real-world testing scenarios — from Selenium UI tests to API automation — ensuring the framework is scalable, reusable, and maintainable.


### Design Pattern Mapping in SDET Framework


                     ┌─────────────────────────┐
                     │    Test Execution Layer │
                     └─────────────┬───────────┘
                                   │
              ┌────────────────────┴────────────────────┐
              │                 Test Flow                │
              │  (Template Method, Strategy, Observer)   │
              └────────────────────┬────────────────────┘
                                   │
            ┌──────────────────────┴──────────────────────┐
            │             Test Logic Layer                 │
            │ (Page Object, Facade, Chain of Responsibility│
            │       Decorator, Data-Driven)                │
            └──────────────────────┬──────────────────────┘
                                   │
            ┌──────────────────────┴──────────────────────┐
            │         Driver & Utility Layer               │
            │ (Singleton, Factory Method, Builder)         │
            └──────────────────────┬──────────────────────┘
                                   │
                      ┌────────────┴────────────┐
                      │  External Data Sources  │
                      │ (Excel, CSV, DB, APIs)  │
                      └────────────────────────┘

- Creational = How you make your tools (WebDriver, utilities)

- Structural = How you arrange your code (Page Objects, Facades)

- Behavioral = How the test behaves during execution (flows, strategies, listeners)

- Data-Driven = How your tests get their input data (anywhere it’s needed)


| Category | Framework Layer | Selenium/SDET Example Patterns |
|----------|----------------|---------------------------------|
| **Creational Patterns** | **Driver & Utility Layer** | - **Singleton** → Single `WebDriver` instance<br>- **Factory** → Browser creation (Chrome, Firefox, etc.)<br>- **Builder** → Test data creation (`UserBuilder`) |
| **Structural Patterns** | **Test Logic Layer** | - **Page Object Model (POM)** → Page classes for UI<br>- **Facade** → Combine multiple page actions into one method<br>- **Decorator** → Wrap WebElements with logging/timing |
| **Behavioral Patterns** | **Test Flow Layer** | - **Strategy** → Switch between different flows (e.g., login types)<br>- **Template Method** → Define a test skeleton (before/after steps)<br>- **Observer** → Listeners for reporting, screenshots |
| **Data-Driven Pattern** | **Cross-cutting** | - Read data from **Excel/CSV/JSON/DB** for tests<br>- Use `@DataProvider` in TestNG<br>- Parameterized tests with different datasets |

---

 
- Put **Creational Patterns** in your `driver` or `utils` package.  
- Put **Structural Patterns** in `pages` or `components`.  
- Put **Behavioral Patterns** in `flows` or `services`.  
- Keep **Data-Driven** logic in a `data` or `resources` package, reusable everywhere.



| Pattern Name              | Definition                                                                 | Selenium Example                                                                |
|---------------------------|-----------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| Singleton Pattern         | Ensures only one instance of a class exists globally.                      | `DriverManager.getDriver()` always returns the same `WebDriver` instance across tests.          |
| Builder Pattern           | Constructs complex objects step-by-step with flexible configuration.       | `User user = new UserBuilder().setName("John").setEmail("john@test.com").build();`               |
| Factory Method Pattern    | Creates objects without specifying the exact class to instantiate.         | `WebDriver driver = DriverFactory.getDriver("chrome");`                                         |
| Page Object Pattern       | Encapsulates UI elements and actions in dedicated classes.                  | `LoginPage login = new LoginPage(driver); login.login("user", "pass");`                         |
| Facade Pattern            | Provides a simplified interface to complex subsystems.                     | `TestHelper.loginAndNavigateToDashboard(driver);`                                               |
| Decorator Pattern         | Dynamically adds new behaviors to existing objects without altering them.   | `WebDriver driver = new EventFiringWebDriver(new ChromeDriver()); driver.register(new Logger());`|
| Strategy Pattern          | Defines a family of algorithms and makes them interchangeable.             | `WaitStrategy wait = new ExplicitWaitStrategy(driver); wait.apply(By.id("element"));`           |
| Observer Pattern          | Allows multiple listeners to react when an event occurs.                    | `TestNG listeners` trigger `onTestFailure()` → capture screenshot & log to report.               |
| Chain of Responsibility   | Passes a request along a chain of handlers until one processes it.          | Form validation chain: `EmptyFieldCheck → EmailFormatCheck → CaptchaCheck`.                     |
| Template Method Pattern   | Defines a skeleton of an algorithm, deferring steps to subclasses.          | `BaseTest` has `setup()` & `tearDown()`, subclasses only implement `executeTest()`.              |
| Data-Driven Pattern       | Executes tests using input data from external sources.                      | `@DataProvider` in TestNG reads Excel & passes multiple username/password sets to one test.      |


`Patterns Implemented:`
----------

# Selenium Design Patterns & Framework Approaches for SDET

| **Category**     | **Pattern / Framework Name** | **Example Use Case** |
|------------------|-----------------------------|---------------------------|
| **Creational**   | Singleton Pattern            | Centralized WebDriver management to ensure a single driver instance across tests |
|                  | Builder Pattern              | Flexible creation of complex test data (e.g., dynamic JSON payloads for API tests) |
|                  | Factory Method Pattern       | Cross-browser WebDriver creation (Chrome, Firefox, Edge) without changing core test code |
| **Structural**   | Page Object Pattern          | Encapsulating UI elements and actions for maintainability and reusability |
|                  | Facade Pattern               | Creating high-level methods that internally call multiple page object methods (e.g., `registerNewUser()`) |
|                  | Decorator Pattern            | Wrapping WebElement to add extra behaviors like highlighting before click, logging actions, auto-screenshot on failure |
|                  | Data-Driven Framework        | Externalizing test data (Excel, CSV, JSON) so tests can run for multiple input sets without code changes |
| **Behavioral**   | Strategy Pattern             | Switching login strategies dynamically (e.g., normal login vs. SSO login) |
|                  | Observer Pattern             | Implementing test listeners for real-time event logging and reporting (TestNG ITestListener + ExtentReports) |
|                  | Chain of Responsibility      | Creating chained validators for UI checks, API checks, and DB validation before test execution |
|                  | Template Method Pattern      | Defining a standard execution flow in a base test class (setup → runTest → teardown) |

# `Highlights`
-------

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

