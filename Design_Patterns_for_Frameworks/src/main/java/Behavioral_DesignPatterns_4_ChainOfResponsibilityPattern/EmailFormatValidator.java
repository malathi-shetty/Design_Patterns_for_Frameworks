package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

public class EmailFormatValidator extends Validator{

	@Override
	public boolean check(String data) {
		 if (!data.contains("@") || !data.contains(".")) {
	            System.out.println("Validation failed: Invalid email format");
	            return false;
	}
		  return next == null || next.check(data);
}
}