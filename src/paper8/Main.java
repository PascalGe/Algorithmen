package paper8;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Game game = new Game();

		// draw the empty board
		System.out.println(game.draw());

		for (int i = 0; i < 16; i++) { // Initialize the game
			game.change(i, 1); // make the two top rows white (o)
			game.change(63 - i, 2); // make the two bottom rows black (x)
		}

		// draw the initialized game
		System.out.println(game.draw());

		// undo the last 5 changes
		game.undoLastChange();
		game.undoLastChange();
		game.undoLastChange();
		game.undoLastChange();
		game.undoLastChange();

		// check if undo worked correctly:
		// in the second row from the top the last two squares should be empty
		// in the second row from the bottom the first three squares should be empty
		System.out.println(game.draw());
	}
}
