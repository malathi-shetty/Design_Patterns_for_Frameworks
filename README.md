# Design_Patterns_for_Frameworks

Overview:
This project demonstrates Java + Maven implementations of key design patterns tailored for SDET and Test Automation.
Each pattern is applied to real-world testing scenarios — from Selenium UI tests to API automation — ensuring the framework is scalable, reusable, and maintainable.

Patterns Implemented:
| -------------- | ----------------------- | ------------------------------------------------- |
| Category       | Pattern Name            | Example SDET Use Case                             |
| -------------- | ----------------------- | ------------------------------------------------- |
| **Creational** | Singleton Pattern       | Centralized WebDriver management                  |
|                | Builder Pattern         | Flexible test data creation                       |
|                | Factory Method Pattern  | Cross-browser WebDriver creation                  |
| -------------- | ----------------------- | ------------------------------------------------- |
| **Structural** | Page Object Pattern     | Encapsulating UI interactions                     |
|                | Facade Pattern          | Simplified high-level test flows                  |
| -------------- | ----------------------- | ------------------------------------------------- |
| **Behavioral** | Strategy Pattern        | Switchable login & verification strategies        |
|                | Observer Pattern        | Test event logging & reporting                    |
|                | Chain of Responsibility | Chained validators for UI, API, and preconditions |
|                | Template Method Pattern | Standardized test flow via base test classes      |
| -------------- | ----------------------- | ------------------------------------------------- |

Highlights
1️⃣ Chain of Responsibility Pattern
Purpose: Chain multiple validators together.

Uses:

Form validation (Demo Form)

API payload checks (JSON Placeholder API)

Test preconditions before execution

2️⃣ Template Method Pattern
Purpose: Define a fixed test flow while allowing subclasses to change specific steps.

SDET Uses:

Standardizing setup/teardown in TestNG/JUnit base classes

UI/API hybrid frameworks where flow stays fixed but execution changes

Regression test templates where verification differs per test

Example:

runTest() defines: setup → executeTest → verify → teardown

Subclasses override only executeTest() and verify().

3️⃣ Strategy Pattern
Switch between UI & API login without modifying test code.

4️⃣ Observer Pattern
Plug-and-play loggers (console, file, extent report).

5️⃣ Singleton Pattern
Single WebDriver instance across all tests to avoid duplicates.


