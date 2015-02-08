package domain;

import DataType.Venue;

public class Administrator extends Director{

	public Administrator(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

	public Venue createNewVenue(String venueName, String venueAddress) {
		return new Venue(venueName, venueAddress);
		
	}

}
