package Behavioral_DesignPatterns_1_StrategyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_TestRunner {
	
	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
	      //  driver.get("https://login");

	        // Use UILogin strategy
	        LoginStrategy uiLogin = new UILogin(driver);
	        LoginContext context = new LoginContext(uiLogin);
	        context.execute("Admin", "admin123");
	        
	        // Use APILogin strategy
	        LoginStrategy apiLogin = new APILogin(driver);
	        context = new LoginContext(apiLogin);
	        context.execute("tomsmith", "SuperSecretPassword!");

	        driver.quit();
	        
	}
}
