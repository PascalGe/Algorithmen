package paper8;

import java.util.ArrayList;

public class Game {

	Board currentBoard;
	ArrayList<Integer> hashSequence; // contains the hash values of the game history

	/**
	 * Creates a new Game.
	 */
	Game() {
		this.currentBoard = new Board();
		this.hashSequence = new ArrayList<Integer>();
		this.hashSequence.add(currentBoard.hash);
	}

	/**
	 * Change one Square.
	 * 
	 * @param position position of the square
	 * @param newState new state of the square
	 */
	public void change(int position, int newState) {
		int hash = currentBoard.change(position, newState);
		if (hash != hashSequence.get(hashSequence.size() - 1)) {
			hashSequence.add(hash);
		}
	}

	/**
	 * to String
	 * 
	 * @return
	 */
	public String draw() {
		return this.currentBoard.draw();
	}

	/**
	 * Undo the last change in the game state
	 */
	public void undoLastChange() {
		// TODO: IMPLEMENT ME
		if (hashSequence.size() > 1) {
			int currentBoardHash = hashSequence.remove(hashSequence.size() - 1);
			// lastAction = newHash ^ oldHash
			int lastActionHash = currentBoardHash ^ hashSequence.get(hashSequence.size() - 1);
			for (int i = 0; i < currentBoard.board.size(); i++) {
				int maybeLastHash = currentBoard.board.get(i).getHash() ^ lastActionHash;
				if (maybeLastHash == currentBoard.board.get(i).getHashEmpty()) {
					// last hash means an empty square
					change(i, Square.EMPTY);
					return;
				} else if (maybeLastHash == currentBoard.board.get(i).getHashBlack()) {
					// last hash means an black square
					change(i, Square.BLACK);
					return;
				} else if (maybeLastHash == currentBoard.board.get(i).getHashWhite()) {
					// last hash means an white square
					change(i, Square.WHITE);
					return;
				}
			}
		}
	}
}
