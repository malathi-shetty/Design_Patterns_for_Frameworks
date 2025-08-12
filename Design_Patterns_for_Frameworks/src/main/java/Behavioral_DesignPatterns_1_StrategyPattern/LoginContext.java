package Behavioral_DesignPatterns_1_StrategyPattern;

public class LoginContext {

	private LoginStrategy strategy;

	public LoginContext(LoginStrategy strategy) {
		this.strategy = strategy;
	}

	public void execute(String user, String pass) {
		strategy.login(user, pass);
	}

}
