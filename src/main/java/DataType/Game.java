package DataType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import domain.Player;
import domain.User;

public abstract class Game {

	public Set<User> players;
	public HashMap<User, Double> playerScoreMap;

	
	public Game(){
		players = new HashSet<User>();
		playerScoreMap = new HashMap<User, Double>();
	}
	
	
	public Set<User> getPlayers() {
		return players;
	}


	public Map<User, Double> getPlayerScoreMap() {
		return playerScoreMap;
	}


	public Double getPlayerScore(Player player) {
		return playerScoreMap.get(player);
	}
}
