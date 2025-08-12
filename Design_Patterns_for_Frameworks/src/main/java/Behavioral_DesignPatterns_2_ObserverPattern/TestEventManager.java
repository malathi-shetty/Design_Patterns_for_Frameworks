package Behavioral_DesignPatterns_2_ObserverPattern;

import java.util.ArrayList;
import java.util.List;



public class TestEventManager {

	private List<TestListener> listeners = new ArrayList<>();

	// Register a listener
	public void addListener(TestListener listener) {
		listeners.add(listener);
		
	}

	// Run the test and notify listeners
	public void runTest(String testName, TestResult result) {
		// Notify listeners that the test is starting
		listeners.forEach(listener -> listener.onTestStart(testName));

		// Simulate running the test (this could be a real test execution)
		System.out.println("Running test: " + testName);

		// Notify listeners that the test has finished
		listeners.forEach(listener -> listener.onTestFinish(testName));
	

	  if (result == TestResult.SUCCESS) {
	        listeners.forEach(listener -> listener.onTestSuccess(testName));
	    } else {
	        listeners.forEach(listener -> listener.onTestFailure(testName));
	    }
}
}
