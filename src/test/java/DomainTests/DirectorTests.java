package DomainTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import DataType.Game;
import DataType.PokerGame;
import domain.Director;
import domain.Player;
import domain.User;

public class DirectorTests {

	private Director director;
	private Player player;
	private Game game;
	private String firstName = "Test";
	private String playerLast = "Player";
	private String directorLast = "Director";
	private String email = "testUser@email.com"; 
	private Double score;
	
	@Before
	public void doSetup(){
		director = new Director(firstName, directorLast, email);
		player = new Player(firstName, playerLast, email);
		game = new PokerGame();
		score = new Double(5);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void directorCanAddPlayerToAGame() throws Exception{
		director.addPlayerToGame(player, game);
		
		assertEquals(player,  game.getPlayers().toArray()[0]);
	}
	
	@Test
	public void directorCanCreateNewPlayer(){
		Player newPlayer = director.createNewPlayer(firstName, playerLast, email);
		
		assertNotNull(newPlayer);		
	}
	
	@Test
	public void directorCanAddScoresToAGame() throws Exception{
		director.addPlayerToGame(player, game);
		director.setPlayerScore(player, score, game);
		
		assertEquals(score, game.getPlayerScore(player));
	}
}
