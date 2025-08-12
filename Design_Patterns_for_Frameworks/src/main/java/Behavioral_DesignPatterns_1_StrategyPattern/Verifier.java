package Behavioral_DesignPatterns_1_StrategyPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Verifier {
    private VerificationStrategy strategy;
    public Verifier(VerificationStrategy strategy) { this.strategy = strategy; }
    public boolean execute(WebDriver driver) { return strategy.verify(driver); }
}
