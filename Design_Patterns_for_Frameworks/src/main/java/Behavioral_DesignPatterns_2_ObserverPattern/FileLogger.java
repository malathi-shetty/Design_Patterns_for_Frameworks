package Behavioral_DesignPatterns_2_ObserverPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements TestListener{

	 private static final String FILE_NAME = "test-log.txt";

	    private void logToFile(String message) {
	        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
	            out.println(message);
	        } catch (IOException e) {
	            System.err.println("Error writing to log file: " + e.getMessage());
	        }
	    }

	    @Override
	    public void onTestStart(String testName) {
	        logToFile("[FileLogger] Test Started: " + testName);
	    }

	    @Override
	    public void onTestSuccess(String testName) {
	        logToFile("[FileLogger] Test Passed: " + testName);
	    }

	    @Override
	    public void onTestFailure(String testName) {
	        logToFile("[FileLogger] Test Failed: " + testName);
	    }

	    @Override
	    public void onTestFinish(String testName) {
	        logToFile("[FileLogger] Test Finished: " + testName);
	    }

}
