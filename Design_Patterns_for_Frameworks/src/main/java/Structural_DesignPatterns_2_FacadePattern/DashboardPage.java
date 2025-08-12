package Structural_DesignPatterns_2_FacadePattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	 public WebDriver driver;
	    
	    private By reportsLink = By.id("reports"); // adjust as needed

	    public DashboardPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void navigateToReports() {
	        driver.findElement(reportsLink).click();
	    }

}
