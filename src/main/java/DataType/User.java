package DataType;

import domain.UserType;


public class User {

	public String email;
	public String firstName;
	public String lastName;
	public UserType userType;

	public User(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = UserType.PLAYER;
	}
}
