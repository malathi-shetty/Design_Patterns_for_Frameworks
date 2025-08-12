package Structural_DesignPatterns_1_PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	// Purpose: Separate UI locators & actions from test logic.
	 public WebDriver driver;

	    private By username = By.id("user");
	    private By password = By.id("pass");
	    private By loginBtn = By.id("login");

	    public LoginPage(WebDriver driver) { this.driver = driver; }

	    public void login(String user, String pass) {
	        driver.findElement(username).sendKeys(user);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(loginBtn).click();
	    }

}
