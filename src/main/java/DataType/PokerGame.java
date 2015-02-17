package DataType;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "pokerGame")
public class PokerGame extends Game {

	public PokerGame(Venue venue) {
		super(venue);
	}

	
	
}
