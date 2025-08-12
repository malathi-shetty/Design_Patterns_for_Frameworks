package Creational_DesignPatterns_2_FactoryMethodPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	public static WebDriver getDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		default:
			throw new IllegalArgumentException("Invalid browser");
		}
	}

}
