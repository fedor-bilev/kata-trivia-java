package trivia;

public interface IGame {

	/**
	 * Adds new player to the game.
	 * @param playerName name of the player
	 * @return has player added successfully
	 */
	boolean add(String playerName);

	/**
	 * Processes a roll for the current payer.
	 * @param roll value of the roll
	 */
	void roll(int roll);

	/**
	 * Submits correct answer for the current player
	 * @return is game still in process
	 */
	boolean wasCorrectlyAnswered();

	/**
	 * Submits wrong answer for the current player
	 * @return is game still in process
	 */
	boolean wrongAnswer();

}