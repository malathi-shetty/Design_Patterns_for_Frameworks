package Behavioral_DesignPatterns_1_StrategyPattern;

import org.openqa.selenium.WebDriver;

public interface VerificationStrategy {
	
	// Purpose: Choose algorithm at runtime (e.g., different verification methods).
	
	 boolean verify(WebDriver driver);

}


