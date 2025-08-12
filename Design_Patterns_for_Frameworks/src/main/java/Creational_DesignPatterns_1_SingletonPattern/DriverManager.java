package Creational_DesignPatterns_1_SingletonPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Purpose: Ensure only one instance of a class exists (e.g., WebDriver instance).
// Common use: WebDriver instance management.
public class DriverManager {

	private static WebDriver driver;

	private DriverManager() {
	} // private constructor - prevent instantiation

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
