package DomainTests;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import DataType.PlayerToGamesMap;
import DataType.User;
import DataType.Venue;
import domain.Director;

public class PlayerToGamesMapTest {

	private PlayerToGamesMap map;
	private User testPlayer;
	private Venue testVenue;
	private Director testDirector;
	
	private final String firstName = "FIRST NAME";
	private final String playerLast = "PLAYER LAST";
	private final String directorLast = "DIRECTOR LAST";
	private final String address = "ADDRESS";
	
	
	@Before
	public void doSetup(){
		map = new PlayerToGamesMap();
		testVenue =  mock(Venue.class);
		testPlayer = mock(User.class);
		testDirector = mock(Director.class);
	}
	
	
	
}
