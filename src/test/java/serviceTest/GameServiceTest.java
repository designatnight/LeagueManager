package serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import service.GameService;
import DataType.PokerGame;
import DataType.Venue;
import domain.Director;
import domain.Player;

public class GameServiceTest {

	public GameService gameService;
	public Director director;
	public Player player;
	public double score;
	public Venue venue;
	
	public final String FIRST_NAME = "test";
	public final String  PLAYER = "player";
	public final String DIRECTOR = "director";
	public final String EMIAL = "test@email.com";
	public final String VENUE = "test venue";
	public final String ADDRESS = "test address"; 
	
	@Before
	public void setup(){
		gameService = new GameService();
		director = new Director(FIRST_NAME, DIRECTOR, EMIAL);
		player = new Player(FIRST_NAME, PLAYER, EMIAL);
		score = new Double(5);
		venue = new Venue(VENUE, ADDRESS);
		
	}
	
	@Test
	public void canGetPlayersScoreTotalFromAllGamesTheyPlayedIn() throws Exception{
		createPlayerThatHasPlayedInManyGames();
		
		Double playerScore = gameService.getPlayerScore(player);
		
		assertEquals(new Double(25), playerScore);
	}
	
	public void createPlayerThatHasPlayedInManyGames() throws Exception{
		for(int i=0; i <5; i++){
			PokerGame game = director.createNewPokerGame(venue);
			director.addPlayerToGame(player, game);
			director.setPlayerScore(player, score, game);
			
		}
	}
}
