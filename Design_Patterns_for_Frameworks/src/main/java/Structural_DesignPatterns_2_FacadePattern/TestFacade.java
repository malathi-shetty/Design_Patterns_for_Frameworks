package Structural_DesignPatterns_2_FacadePattern;

import org.openqa.selenium.WebDriver;

import Structural_DesignPatterns_1_PageObjectPattern.LoginPage;

public class TestFacade {
	// Purpose: Provide a simpler interface to a complex system. - a simplified interface to multiple classes.
	
	private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public TestFacade(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    public void loginAndNavigate(String user, String pass) {
        loginPage.login(user, pass);
        dashboardPage.navigateToReports();
	    }

}
