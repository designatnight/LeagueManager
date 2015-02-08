package domain;

import java.util.List;
import java.util.Set;

import exceptions.UnableToAddUserToGameException;

import DataType.Game;

public class Director extends User{

	public Director(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}

	public void addPlayerToGame(User player, Game game) throws Exception {
		
		Set<User> players = game.getPlayers();
		if(player != null && !players.contains(player)){
			players.add(player);
		}else {
			throw new UnableToAddUserToGameException();
		}
		
	}

	public Player createNewPlayer(String firstName, String lastName, String email) {
		return new Player(firstName, lastName, email);
		
	}

	public void setPlayerScore(User player, Double score, Game game) {
		game.getPlayerScoreMap().put(player,score);
	}
	
	

}
