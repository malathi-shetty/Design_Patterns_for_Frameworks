package Behavioral_DesignPatterns_2_ObserverPattern;

public class ExtentReportListener implements TestListener{

	@Override
	public void onTestStart(String testName) {
		System.out.println("Started: " + testName);
		
	}

	@Override
	public void onTestFinish(String testName) {
		System.out.println("Finished: " + testName);
		
	}

	@Override
	public void onTestSuccess(String testName) {
		System.out.println("Extent: Passed " + testName);
		
	}

	@Override
	public void onTestFailure(String testName) {
		System.out.println("Extent: Failed " + testName);
		
	}
	
	

}
