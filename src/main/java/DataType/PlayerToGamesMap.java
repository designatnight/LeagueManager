package DataType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PlayerToGamesMap {

	public HashMap<User ,Set<Game>> map;
	
	public PlayerToGamesMap(){
		map = new HashMap<User, Set<Game>>();
	}
	
	public void addPlayerToMap(User player){
		Set<Game> set = new HashSet<Game>();
		map.put(player, set);
	}
	
	public void addGameToPlayerSet(User player, Game game){
		Set<Game> gameSet = map.get(player);
		gameSet.add(game);
	}
	
	public Set<Game> getPlayerGameSet(User player){
		return map.get(player);
	}
}
