package service;

import java.util.HashMap;
import java.util.Set;

import DataType.Game;
import DataType.PlayerToGamesMap;
import DataType.PokerGame;
import DataType.User;
import DataType.VenueToGamesMap;
import domain.Administrator;
import domain.Director;


public class GameService {

	
	public VenueToGamesMap venueMap;
	public HashMap<String, Double> awards;
	public PlayerToGamesMap playerMap;
	
	public GameService(){
		venueMap = new VenueToGamesMap();
		awards = new HashMap<String, Double>();
		playerMap = new PlayerToGamesMap();
	}
	
	public void addAward(String awardName, Double awardValue){
		awards.put(awardName, awardValue);
	}
	
	public double getAwardValue(String awardName){
		return awards.get(awardName);
	}
	
	public Double getPlayerScore(User player) {
		Set<Game> gameSet = playerMap.getPlayerGameSet(player);
		Double score = new Double(0);
		for (Game game : gameSet){
			score += game.getPlayerScore(player);
			if(game.playerAwards.get(player) != null){
				for(String awardName : game.playerAwards.get(player)){
					score += awards.get(awardName);
				}
			}
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
