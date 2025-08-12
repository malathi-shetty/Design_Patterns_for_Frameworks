package Creational_DesignPatterns_2_FactoryMethodPattern;

// Purpose: Create objects without exposing creation logic. - Encapsulate object creation logic.
import org.openqa.selenium.WebDriver;

public interface DriverFactory {
	 WebDriver createDriver();
}
