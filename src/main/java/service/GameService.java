package service;

import java.util.Set;

import DataType.Game;
import DataType.PlayerToGamesMap;
import DataType.VenueToGamesMap;
import domain.Player;


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

	
}
