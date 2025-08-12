package Structural_DesignPatterns_2_FacadePattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
	        driver.get("https://login");

	        TestFacade facade = new TestFacade(driver);
	        facade.loginAndNavigate("admin", "admin123");
	        
	        // Add assertions here...

	        driver.quit();

	}

}
