package Behavioral_DesignPatterns_3_TemplateMethodPattern;

public abstract class TestTemplate {
	  public final void runTest() {
	        setup();
	        executeTest();
	        verify();
	        teardown();
	    }
	  
	  protected void setup() {
	        System.out.println("Setup WebDriver");
	    }

	    protected void teardown() {
	        System.out.println("Quit WebDriver");
	    }

	    protected abstract void executeTest();
	    protected abstract void verify();
	}