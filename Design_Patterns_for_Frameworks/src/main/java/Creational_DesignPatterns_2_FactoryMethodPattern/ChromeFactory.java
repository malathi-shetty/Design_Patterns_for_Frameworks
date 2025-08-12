package Creational_DesignPatterns_2_FactoryMethodPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeFactory implements DriverFactory {

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return new ChromeDriver();
	}

	public class FirefoxFactory implements DriverFactory {

		@Override
		public WebDriver createDriver() {
			// TODO Auto-generated method stub
			return new FirefoxDriver();
		}

	}
}