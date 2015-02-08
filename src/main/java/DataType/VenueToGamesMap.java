package DataType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VenueToGamesMap {

	public HashMap<Venue, Set<Game>> map;
	
	public VenueToGamesMap(){
		map = new HashMap<Venue, Set<Game>>();
	}
	
	public void addVenue(Venue venue){
		Set<Game> set = new HashSet<Game>();
		map.put(venue, set);
	}
	
	public void addGameToVenueSet(Venue venue, Game game){
		Set<Game> gameSet = map.get(venue);
		gameSet.add(game);
	}
	
}
