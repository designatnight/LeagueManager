package service;

import java.util.Set;

import DataType.Game;
import DataType.PlayerToGamesMap;
import DataType.PokerGame;
import DataType.VenueToGamesMap;
import domain.Administrator;
import domain.Director;
import domain.Player;
import domain.User;


public class GameService {

	
	public VenueToGamesMap venueMap;
	public PlayerToGamesMap playerMap;
	
	public GameService(){
		venueMap = new VenueToGamesMap();
		playerMap = new PlayerToGamesMap();
	}
	
	
	public Double getPlayerScore(Player player) {
		Set<Game> gameSet = playerMap.getPlayerGameSet(player);
		Double score = new Double(0);
		for (Game game : gameSet){
			score += game.getPlayerScore(player);
		}
		return score;
	}


	public void submitGame(Director director, PokerGame game) throws Exception {
		venueMap.addGameToVenueSet(game.getVenue(), game);
		for(User player : game.getPlayers()){
			playerMap.addGameToPlayerSet(player, game);
		}
	}

	public void submitGame(Administrator administrator, PokerGame game) throws Exception {
		venueMap.addGameToVenueSet(game.getVenue(), game);
		for(User player : game.getPlayers()){
			playerMap.addGameToPlayerSet(player, game);
		}
	}
	
}
