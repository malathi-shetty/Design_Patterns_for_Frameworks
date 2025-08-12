package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PreconditionTest {
	
	 @BeforeClass
	    public void checkPreconditions() {
	        String baseUrl = "https://jsonplaceholder.typicode.com/posts";

	        Validator chain = new NotEmptyValidator();
	        if (!chain.check(baseUrl)) {
	            throw new RuntimeException("Precondition failed: Base URL invalid");
	        }
	    }

	    @Test
	    public void testApiCall() {
	        System.out.println("Running test because preconditions passed");
	    }

}
