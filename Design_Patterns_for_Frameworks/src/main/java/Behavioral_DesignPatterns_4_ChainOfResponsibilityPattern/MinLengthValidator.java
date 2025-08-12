package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

public class MinLengthValidator extends Validator{

	// Validator: Min Length
	
	private int minLength;
    public MinLengthValidator(int minLength) {
        this.minLength = minLength;
    }
    
	@Override
	public boolean check(String data) {
		
	        if (data.length() < minLength) {
	            System.out.println("Validation failed: Minimum length is " + minLength);
	            return false;
	        }
	        return next == null || next.check(data);
	}

}
