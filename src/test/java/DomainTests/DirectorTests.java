package DomainTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import DataType.Game;
import DataType.PokerGame;
import DataType.User;
import domain.Director;
import exceptions.UnableToAddUserToGameException;

public class DirectorTests {

	private Director director;
	private User player;
	private Game game;
	private String firstName = "Test";
	private String playerLast = "Player";
	private String directorLast = "Director";
	private String email = "testUser@email.com"; 
	private Double score;
	
	@Before
	public void doSetup(){
		director = new Director(firstName, directorLast, email);
		player = new User(firstName, playerLast, email);
		game = new PokerGame(null);
		score = new Double(5);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void directorCanAddPlayerToAGame() throws Exception{
		director.addPlayerToGame(player, game);
		
		assertEquals(player,  game.getPlayers().toArray()[0]);
	}
	
	@Test (expected=UnableToAddUserToGameException.class)
	public void directorCanNotAddSamePlayerToGameTwice() throws Exception{
		director.addPlayerToGame(player, game);
		director.addPlayerToGame(player, game);
		
	}
	
	@Test
	public void directorCanCreateNewPlayer(){
		User newPlayer = director.createNewPlayer(firstName, playerLast, email);
		
		assertNotNull(newPlayer);		
	}
	
	@Test
	public void directorCanCreateNewPokerGame(){
		
		PokerGame pokerGame = director.createNewPokerGame(null);
		
		assertNotNull(pokerGame);
		
	}
	
	@Test
	public void directorCanAddScoresToAGame() throws Exception{
		director.addPlayerToGame(player, game);
		director.setPlayerScore(player, score, game);
		
		assertEquals(score, game.getPlayerScore(player));
	}
}
