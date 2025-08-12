package Behavioral_DesignPatterns_3_TemplateMethodPattern;

public class LoginTest extends TestTemplate{

	@Override
	protected void executeTest() {
		 System.out.println("Executing login steps");
		
	}

	@Override
	protected void verify() {
		 System.out.println("Verifying login success");
		
	}

}
