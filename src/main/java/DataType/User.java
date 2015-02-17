package DataType;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import domain.UserType;
//TODO: should I use and ID rather than username as key?
@DynamoDBTable(tableName = "user")
public class User {

	public String email;
	public String firstName;
	public String lastName;
	public UserType userType;
	public String userName;

	public User(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = UserType.PLAYER;
	}
	
	@DynamoDBHashKey(attributeName = "userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@DynamoDBAttribute
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@DynamoDBAttribute
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
