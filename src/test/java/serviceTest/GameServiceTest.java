package serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import service.GameService;
import DataType.PokerGame;
import DataType.User;
import DataType.Venue;
import domain.Director;

public class GameServiceTest {

	public GameService gameService;
	public Director director;
	public User player;
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
		player = new User(FIRST_NAME, PLAYER, EMIAL);
		score = new Double(5);
		venue = new Venue(VENUE, ADDRESS);
		gameService.venueMap.addVenue(venue);
		gameService.playerMap.addPlayerToMap(player);
	}
	
	@Test
	public void canGetPlayersScoreTotalFromAllGamesTheyPlayedIn() throws Exception{
		createPlayerThatHasPlayedInManyGames();
		
		Double playerScore = gameService.getPlayerScore(player);
		
		assertEquals(new Double(25), playerScore);
	}
	
	@Test
	public void directorAndAdministratorsCanSubmitGames() throws Exception{
		PokerGame game = director.createNewPokerGame(venue);
		director.addPlayerToGame(player, game);
		director.setPlayerScore(player, score, game);
		gameService.submitGame(director, game);
		
		assertEquals( 1, gameService.playerMap.getPlayerGameSet(player).size());
	}
	
	public void createPlayerThatHasPlayedInManyGames() throws Exception{
		for(int i=0; i <5; i++){
			PokerGame game = director.createNewPokerGame(venue);
			director.addPlayerToGame(player, game);
			director.setPlayerScore(player, score, game);
			gameService.submitGame(director, game);
		}
	}
}
