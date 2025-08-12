package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormValidation_TestRunner {

	public static void main(String[] args) {
		  // Selenium setup
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String emailInput = "test@example.com";

        // Create validation chain
        Validator chain = new NotEmptyValidator();
        chain.linkWith(new MinLengthValidator(5))
             .linkWith(new EmailFormatValidator());

        if (chain.check(emailInput)) {
            driver.findElement(By.name("my-text")).sendKeys(emailInput);
            driver.findElement(By.cssSelector("button")).click();
            System.out.println("Form submitted");
        } else {
            System.out.println("Form not submitted due to validation failure");
        }

        driver.quit();

	}

}
