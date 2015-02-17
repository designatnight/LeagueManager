package serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import service.GameService;
import DataType.Game;
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
	public final String ONE_POINT_AWARD = "onePointAward";
	public final String TWO_POINT_AWARD = "twoPointAward";
	
	
	@Before
	public void setup(){
		gameService = new GameService();
		director = new Director(FIRST_NAME, DIRECTOR, EMIAL);
		player = new User(FIRST_NAME, PLAYER, EMIAL);
		score = new Double(5);
		venue = new Venue(VENUE, ADDRESS);
		gameService.venueMap.addVenue(venue);
		gameService.playerMap.addPlayerToMap(player);
		gameService.addAward(ONE_POINT_AWARD, new Double(1));
		gameService.addAward(TWO_POINT_AWARD, new Double(2));
	}
	
	@Test
	public void canGetPlayersScoreTotalFromAllGamesTheyPlayedInNoAwards() throws Exception{
		createPlayerThatHasPlayedInManyGames(false);
		
		Double playerScore = gameService.getPlayerScore(player);
		
		assertEquals(new Double(25), playerScore);
		Game[] games = (Game[]) gameService.playerMap.getPlayerGameSet(player).toArray();
		Game game = games[0];
		assertNull(game.getPlayerAward(player).get(0));
	}
	
	@Test
	public void canGetPlayersScoreTotalFromAllGamesTheyPlayedInHas1AwardForEachGame() throws Exception{
		createPlayerThatHasPlayedInManyGames(true);
		
		Double playerScore = gameService.getPlayerScore(player);
		
		assertEquals(new Double(30), playerScore);
	}
	
	@Test
	public void canGetPlayersScoreTotalFromAllGamesTheyPlayedInHas2AwardsForEachGame() throws Exception{
		createPlayerThatHasPlayedInManyGames(true);
		List<String> awards = new ArrayList<String>();
		awards.add(ONE_POINT_AWARD);
		awards.add(TWO_POINT_AWARD);
		for(Game game : gameService.playerMap.getPlayerGameSet(player)){
			game.addPlayerAward(player, awards);
		}
		Double playerScore = gameService.getPlayerScore(player);
		
		assertEquals(new Double(40), playerScore);
	}
	
	@Test
	public void directorAndAdministratorsCanSubmitGames() throws Exception{
		PokerGame game = director.createNewPokerGame(venue);
		director.addPlayerToGame(player, game);
		director.setPlayerScore(player, score, game);
		gameService.submitGame(director, game);
		
		assertEquals( 1, gameService.playerMap.getPlayerGameSet(player).size());
	}
	
	public void createPlayerThatHasPlayedInManyGames(boolean hasAwards) throws Exception{
		for(int i=0; i <5; i++){
			PokerGame game = director.createNewPokerGame(venue);
			director.addPlayerToGame(player, game);
			director.setPlayerScore(player, score, game);
			gameService.submitGame(director, game);
			if(hasAwards){
				List<String> awards = new ArrayList<String>();
				awards.add(ONE_POINT_AWARD);
				game.addPlayerAward(player, awards);
			}
		}
	}
}
