package Behavioral_DesignPatterns_3_TemplateMethodPattern;

public class TemplatePattern_TestRunner {
	
	 public static void main(String[] args) {
	        TestTemplate loginTest = new LoginTest();
	        loginTest.runTest();

	        TestTemplate searchTest = new SearchTest();
	        searchTest.runTest();
	    }

}
