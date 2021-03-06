package paper8;

import java.util.ArrayList;
import java.util.Random;

public class Board {

	public ArrayList<Square> board; // Board of 8 x 8 =64 Squares
	public int hash;

	/**
	 * Initialize a new board where the individual hashes are randomly generated
	 */
	Board() {

		this.board = new ArrayList<Square>();

		for (int i = 0; i < 64; i++) {
			int hashEmpty = newHash();
			int hashWhite = newHash();
			int hashBlack = newHash();
			Square s = new Square(Square.EMPTY, hashEmpty, hashWhite, hashBlack);
			board.add(s);
		}
		this.hash = computeHash();
	}

	/**
	 * Randomly generates hash values. (No collision check, the hash values could be
	 * the same, but that is very unlikely.)
	 * 
	 * @return
	 */
	private int newHash() {
		Random rand = new Random();
		int randomNum = rand.nextInt();
		return randomNum;
	}

	/**
	 * Computes hash of the board in the initialization process. Not to be used when
	 * changing the game state. DANGER: USING THIS FUNCTION WHILE CHANGING THE GAME
	 * STATE, MIGHT LEAD TO SEVERE INJURY AND LOSS OF ÜBUNGSPOINTS.
	 * 
	 * @return
	 */
	private int computeHash() {

		// TODO: IMPLEMENT ME
		int hash = 0;
		for (int i = 0; i < board.size(); i++) {
			hash = hash ^ board.get(i).getHash();
		}
		return hash;
	}

	/**
	 * The value of one board position is changed. Student exercise
	 * 
	 * @param position 0 to 63
	 * @param newState
	 * @return
	 */
	public int change(int position, int newState) {

		// TODO: IMPLEMENT ME
		// get current square
		Square square = board.get(position);
		// hash out old content
		hash ^= square.getHash();
		// set new content
		square.setContent(newState);
		// hash in new content
		hash ^= square.getHash();
		return hash;
	}

	/**
	 * print the current board content
	 * 
	 * @return
	 */
	public String draw() {
		String coolMinus = "\u2014";
		String sep = "";

		for (int i = 0; i < 17; i++) {
			sep += coolMinus;
		}
		sep += "\n";

		String s = sep;
		for (int i = 0; i < 64; i++) {
			s += "|" + this.board.get(i).draw();
			if (i % 8 == 7) {
				s += "|\n" + sep;
			}
		}
		return s;
	}
}
