import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	// Constants
	private final int WINNING_NUM = 8;
	private final int CHUTE_NUM = 8;
	private final int LADDERS_NUM = 8;

	// All the following will have 2 cols, the first is for the start position and the second is for the end position
	private int[][] chutes;
	private int[][] ladders;

	private Map<Player, Integer> playerPositions;
	
	private String currentBoardState = "";

	/**
	 * @param players the player who are in this game.
	 */
	public Board(List<Player> players){

		//Initialize 
		this.playerPositions = new HashMap<Player, Integer>();
		for (Player player : players){
			this.playerPositions.put(player, 0);
		}
		
		initBoard();

	}

	/**
	 * Moves the given player based on the value provided.
	 * @param player
	 * @param value dice value
	 * @return True if current player reach WINNING NUM
	 */
	public void movePlayer(Player player, int value){

		int prePosition = playerPositions.get(player);
		int newPosition = (prePosition + value) >= WINNING_NUM ? WINNING_NUM : (prePosition + value);
		
		this.currentBoardState = player.getName() + ": " + prePosition + " --> " + newPosition;

		if (newPosition == WINNING_NUM){
			playerPositions.put(player, WINNING_NUM);
			return;
		}
		
		 
		// Check if new is at a chute position
		for (int i = 0; i < CHUTE_NUM; i++){
			if (chutes[i][0] == newPosition){
				newPosition = chutes[i][1];
				this.currentBoardState += " --CHUTE--> " + newPosition;
				break;
			}
		}

		// check if new is at ladder position
		for (int i = 0; i < LADDERS_NUM; i++){
			if (ladders[i][0] == newPosition){
				newPosition = ladders[i][1];
				this.currentBoardState += " --LADDER--> " + newPosition;
				break;
			}
		}

		playerPositions.put(player, newPosition);
		return;
	}
	
	
	/**
	 * check if the given player has reached the end
	 * @param player
	 */
	public boolean isPlayerDone(Player player) {
		return 	 playerPositions.get(player) == WINNING_NUM;
	}
	
	
	/**
	 * return current state of the board. Gets updated after a player is moved
	 */
	public String getCurrentBoardState() {
		return this.currentBoardState;
	}

	private void initBoard(){
		chutes = new int[CHUTE_NUM][2];
		ladders = new int[LADDERS_NUM][2];
				
		chutes[0][0] = 17;
		chutes[0][1] = 7;
		chutes[1][0] = 54;
		chutes[1][1] = 34;
		chutes[2][0] = 62;
		chutes[2][1] = 19;
		chutes[3][0] = 64;
		chutes[3][1] = 60;
		chutes[4][0] = 87;
		chutes[4][1] = 24;
		chutes[5][0] = 93;
		chutes[5][1] = 73;
		chutes[6][0] = 95;
		chutes[6][1] = 75;
		chutes[7][0] = 99;
		chutes[7][1] = 78;
		
		ladders[0][0] = 4;
		ladders[0][1] = 14;
		ladders[1][0] = 9;
		ladders[1][1] = 31;
		ladders[2][0] = 20;
		ladders[2][1] = 38;
		ladders[3][0] = 28;
		ladders[3][1] = 84;
		ladders[4][0] = 40;
		ladders[4][1] = 59;
		ladders[5][0] = 51;
		ladders[5][1] = 67;
		ladders[6][0] = 63;
		ladders[6][1] = 81;
		ladders[7][0] = 71;
		ladders[7][1] = 91;
	}
	
}
