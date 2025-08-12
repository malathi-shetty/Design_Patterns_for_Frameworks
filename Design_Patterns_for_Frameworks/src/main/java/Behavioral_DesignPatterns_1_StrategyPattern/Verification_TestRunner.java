package Behavioral_DesignPatterns_1_StrategyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verification_TestRunner {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://dashboard");

		Verifier verifier = new Verifier(new TitleVerification());
		boolean isTitleCorrect = verifier.execute(driver);

		Verifier elementVerifier = new Verifier(new ElementVerification());
		boolean isElementPresent = elementVerifier.execute(driver);

		driver.quit();
	}

}
