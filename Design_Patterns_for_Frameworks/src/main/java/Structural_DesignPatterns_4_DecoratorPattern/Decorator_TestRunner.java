package Structural_DesignPatterns_4_DecoratorPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Decorator_TestRunner {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/login");

	        WebElement username = new ElementDecorator(driver.findElement(By.id("username")), driver);
	        WebElement password = new ElementDecorator(driver.findElement(By.id("password")), driver);
	        WebElement loginBtn = new ElementDecorator(driver.findElement(By.cssSelector("button[type='submit']")), driver);

	        username.sendKeys("tomsmith");
	        password.sendKeys("SuperSecretPassword!");
	        loginBtn.click();

	        driver.quit();

	}

}
