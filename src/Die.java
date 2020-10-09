import java.util.Random;

public class Die {

	private Random rand;
	
	/**
	 * Initialize the fields
	 */
	public Die(){
		rand = new Random();
	}
	
	
	/**
	 * @return returns a random value between 1 and 6
	 */
	public int roll(){
		return rand.nextInt(6)+1;
	}
}