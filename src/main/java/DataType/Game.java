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
	public Venue venue;

	
	public Game(Venue venue){
		players = new HashSet<User>();
		playerScoreMap = new HashMap<User, Double>();
		this.venue = venue;
	}
	
	
	public Set<User> getPlayers() {
		return players;
	}

	public void addPlayer(User player){
		players.add(player);
	}

	public Map<User, Double> getPlayerScoreMap() {
		return playerScoreMap;
	}

	public void setPlayerScore(User player, Double score){
		playerScoreMap.put(player, score);
	}

	public Double getPlayerScore(Player player) {
		return playerScoreMap.get(player);
	}
	
	public Venue getVenue(){
		return venue;
	}
}
