package Behavioral_DesignPatterns_1_StrategyPattern;

import org.openqa.selenium.WebDriver;

public class TitleVerification implements VerificationStrategy {

	@Override
	public boolean verify(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.getTitle().contains("Dashboard");
	}

}
