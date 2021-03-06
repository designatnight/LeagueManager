package DomainTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import DataType.User;
import DataType.Venue;
import domain.Administrator;
import domain.Director;

public class AdministratorTest {

	private Administrator administrator;
	private Director director;
	private User player;
	private Venue venue;
	
	private String firstName = "Test";
	private String playerLast = "Player";
	private String directorLast = "Director";
	private String administratorLast = "Administrator";
	private String email = "testUser@email.com"; 
	private String venueName = "testVenue";
	private String venueAddress = "testVenueAddress";
	
	
	@Before
	public void doSetup(){
		administrator = new Administrator(firstName, administratorLast, email);
		/*director = new Director(firstName, directorLast, email);
		player = new Player(firstName, playerLast, email);*/
	}
	
	@Test
	public void administratorCanCreateNewVenue(){
		venue = administrator.createNewVenue(venueName, venueAddress);
		
		assertNotNull(venue);
	}
	
	@Test
	public void administratorCanCreateNewDirector(){
		director = administrator.createNewDirector(firstName, directorLast, email);
		
		assertNotNull(director);
	}
	
}
