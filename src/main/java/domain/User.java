package domain;

public abstract class User {

	public String email;
	public String firstName;
	public String lastName;

	public User(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
