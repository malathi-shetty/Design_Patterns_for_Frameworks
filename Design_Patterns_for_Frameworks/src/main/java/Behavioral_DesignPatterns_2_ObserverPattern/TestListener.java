package Behavioral_DesignPatterns_2_ObserverPattern;

// Purpose: Event-driven test logging.
public interface TestListener {
	 void onTestStart(String testName);
	 void onTestSuccess(String testName);
	    void onTestFailure(String testName);
	    void onTestFinish(String testName);
	    
	  
	}