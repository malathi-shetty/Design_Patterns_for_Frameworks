package Behavioral_DesignPatterns_2_ObserverPattern;

public class ConsoleLogger implements TestListener {

	 @Override
	    public void onTestStart(String testName) {
	        System.out.println("[Console] Test Started: " + testName);
	    }

	    @Override
	    public void onTestSuccess(String testName) {
	        System.out.println("[Console] Test Passed: " + testName);
	    }

	    @Override
	    public void onTestFailure(String testName) {
	        System.out.println("[Console] Test Failed: " + testName);
	    }

	    @Override
	    public void onTestFinish(String testName) {
	        System.out.println("[Console] Test Finished: " + testName);
	    }

}
