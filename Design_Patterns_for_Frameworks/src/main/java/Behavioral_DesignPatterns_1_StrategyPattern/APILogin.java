package Behavioral_DesignPatterns_1_StrategyPattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APILogin implements LoginStrategy {
	
	 private WebDriver driver;

	    public APILogin(WebDriver driver) {
	        this.driver = driver;
	    }


	@Override
	public void login(String user, String pass) {
		
		 driver.get("https://the-internet.herokuapp.com/login");

//	        driver.findElement(By.name("username")).sendKeys(user);
//	        driver.findElement(By.name("password")).sendKeys(pass);
//	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        
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
	        
		System.out.println("API login with " + user);
		 // Simulate API login (e.g., send HTTP request)
	}

}
