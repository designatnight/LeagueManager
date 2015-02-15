package DomainTests;

import org.junit.Before;
import static org.mockito.Mockito.mock;
import DataType.PlayerToGamesMap;
import DataType.Venue;
import domain.Director;
import domain.Player;

public class PlayerToGamesMapTest {

	private PlayerToGamesMap map;
	private Player testPlayer;
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
		testPlayer = mock(Player.class);
		testDirector = mock(Director.class);
	}
	
	
	
}
