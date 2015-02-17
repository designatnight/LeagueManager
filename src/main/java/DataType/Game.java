package DataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Game {

	public Set<User> players;
	public HashMap<User, Double> playerScoreMap;
	public HashMap<User, List<String>> playerAwards;
	public Venue venue;

	
	public Game(Venue venue){
		players = new HashSet<User>();
		playerScoreMap = new HashMap<User, Double>();
		playerAwards = new HashMap<User, List<String>>();
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
		setPlayerAward(player);
	}

	public Double getPlayerScore(User player) {
		return playerScoreMap.get(player);
	}
	
	public void setPlayerAward(User player){
		playerAwards.put(player, new ArrayList<String>());		
	}
	
	public void addPlayerAward(User player, List<String> awards){
		playerAwards.put(player, awards);
	}
	
	public List<String> getPlayerAward(User player){
		if(playerAwards.get(player) == null){
			playerAwards.put(player, new ArrayList<String>());
		}
		return playerAwards.get(player);
	}
	
	public Venue getVenue(){
		return venue;
	}
}
