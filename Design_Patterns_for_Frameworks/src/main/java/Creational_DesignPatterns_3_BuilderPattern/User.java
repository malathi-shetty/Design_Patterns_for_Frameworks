package Creational_DesignPatterns_3_BuilderPattern;

// Purpose: Step-by-step object construction.
// Useful for test data objects.
public class User {

	private String username;
	private String email;
	private boolean isAdmin;

	public static class Builder {
		private String username;
		private String email;
		private boolean isAdmin;

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setAdmin(boolean admin) {
			this.isAdmin = admin;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	private User(Builder builder) {
		this.username = builder.username;
		this.email = builder.email;
		this.isAdmin = builder.isAdmin;
	}

}
