package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

public class NotEmptyValidator extends Validator{

	// Validator: Not Empty
	@Override
	public boolean check(String data) {
		 if (data == null || data.trim().isEmpty())  {
	            System.out.println("Validation failed: Empty data");
	            return false;
		
	}
		 return next == null || next.check(data);
}
}