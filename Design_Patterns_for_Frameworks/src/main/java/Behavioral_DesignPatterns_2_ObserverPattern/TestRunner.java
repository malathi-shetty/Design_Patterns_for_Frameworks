package Behavioral_DesignPatterns_2_ObserverPattern;

public class TestRunner {

	public static void main(String[] args) {
		// Create a TestEventManager instance
        TestEventManager eventManager = new TestEventManager();

        // Register your listeners
        eventManager.addListener(new ExtentReportListener());
         eventManager.addListener(new ConsoleLogger()); // if you have others
         eventManager.addListener(new FileLogger());    // optional

        // Run the test
        eventManager.runTest("LoginTest", TestResult.SUCCESS); // or FAILURE
        eventManager.runTest("SearchTest", TestResult.FAILURE);
	}

}
