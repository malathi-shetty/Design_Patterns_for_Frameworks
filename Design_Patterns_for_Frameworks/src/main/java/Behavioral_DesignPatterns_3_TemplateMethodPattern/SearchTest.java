package Behavioral_DesignPatterns_3_TemplateMethodPattern;

public class SearchTest extends TestTemplate{

	@Override
	protected void executeTest() {
		 System.out.println("Executing search steps");
		
	}

	@Override
	protected void verify() {
		 System.out.println("Verifying search results");
		
	}

}
