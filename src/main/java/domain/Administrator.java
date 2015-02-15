package domain;

import DataType.Venue;

public class Administrator extends Director{
	
	public Administrator(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

	public Venue createNewVenue(String venueName, String venueAddress) {
		Venue venue = new Venue(venueName, venueAddress);	
		return venue;
		
	}
	
	public Director createNewDirector(String firstName, String lastName, String email){
		return new Director(firstName, lastName, email);
	}

	//TODO: this will need to be updated to account for when users are upgraded so that their stats move with them.
	public Director createNewDirector(User user){
		return new Director(user.firstName, user.lastName, user.email);
	}

}
