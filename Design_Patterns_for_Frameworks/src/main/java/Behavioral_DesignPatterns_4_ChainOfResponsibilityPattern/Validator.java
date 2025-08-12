package Behavioral_DesignPatterns_4_ChainOfResponsibilityPattern;

//Abstract handler
public abstract class Validator {

	
	 protected Validator next;

	    public Validator linkWith(Validator next) {
	        this.next = next;
	        return next;
	    }

	    public abstract boolean check(String data);
	}

