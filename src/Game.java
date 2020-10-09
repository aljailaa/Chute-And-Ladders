import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// get num of players from user
		int playersNum = 0;
		while (playersNum > 4 || playersNum < 2 ) {
			System.out.print("Please enter the number of player (2-4): ");
			playersNum = scan.nextInt();
		}

		// Initialize players
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < playersNum; i++) {
			players.add(new Player("Player " + i));
		}

		// Initialize board and dice
		Board board = new Board(players);
		Dice dice = new Dice();
		// 

		// Loop until one of the players reach the end
		int currentIndex = 0;
		Player currentPlayer = null;
		do  {
			 // get the next player and play their turn
			 currentPlayer = players.get(currentIndex % playersNum);
			 int roll = currentPlayer.rollDice(dice);
			 board.movePlayer(currentPlayer, roll);

			// Print the current state
			System.out.println((currentIndex + 1) + ":" + board.getCurrentBoardState());

		    // update
			currentIndex++;

		} while (!board.isPlayerDone(currentPlayer));
		
		System.out.println("The winner is " + currentPlayer.getName() + "!");
	}
}
