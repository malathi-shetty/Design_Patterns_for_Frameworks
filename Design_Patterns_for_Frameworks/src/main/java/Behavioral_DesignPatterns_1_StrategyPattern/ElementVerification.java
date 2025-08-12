package Behavioral_DesignPatterns_1_StrategyPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementVerification implements VerificationStrategy{

	@Override
	public boolean verify(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.id("welcome")).isDisplayed();
	}

}
