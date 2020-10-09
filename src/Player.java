public class Player {

	private String name;

	public Player(String name) {
		this.name = name;
	}

	/**
	 * @return What the die returns for this use
	 */
	public int takeTurn(Die die) {	
		return die.roll();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}