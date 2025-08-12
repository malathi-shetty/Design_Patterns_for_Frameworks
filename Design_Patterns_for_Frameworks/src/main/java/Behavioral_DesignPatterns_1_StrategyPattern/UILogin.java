package Behavioral_DesignPatterns_1_StrategyPattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UILogin implements LoginStrategy {

	private WebDriver driver;

	public UILogin(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void login(String user, String pass) {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  // Wait for and fill username field
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
	            .sendKeys(user);

	        // Wait for and fill password field
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
	            .sendKeys(pass);

	        // Wait for and click login button
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")))
	            .click();

		System.out.println("UI login attempted with user: " + user);
		// Simulate UI login or call Selenium code here
	}

}
