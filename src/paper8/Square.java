package paper8;

public class Square {
	
	public static final int EMPTY = 0; // square is empty
	public static final int WHITE = 1; // square is white
	public static final int BLACK = 2; // square is black

	
	private int content; 	// One of EMPTY, WHITE or BLACK
	
	// every square has hash values depending on its state
	private int hashEmpty; // hash if square is 	empty
	private int hashWhite; // 						white
	private int hashBlack; //						black


	/**
	 * Creates a new square
	 * @param content   content of this square
	 * @param hashEmpty hash value for empty
	 * @param hashWhite hash value for white
	 * @param hashBlack hash value for black
	 */
	Square(int content, int hashEmpty, int hashWhite, int hashBlack) {
		this.content = content;
		this.hashEmpty = hashEmpty;
		this.hashWhite = hashWhite;
		this.hashBlack = hashBlack;
	} 

	
	/**
	 * Returns the current hash value of this square
	 * @return hash value
	 */
	public int getHash() {

		if (this.content == EMPTY) {
			return hashEmpty;

		}
		else if (this.content == WHITE) {
			return hashWhite;
		}
		else {
			return hashBlack;
		}		

	}


	
	public int getHashEmpty() {
		return hashEmpty;
	}

	public void setHashEmpty(int hashEmpty) {
		this.hashEmpty = hashEmpty;
	}



	public int getHashWhite() {
		return hashWhite;
	}

	public void setHashWhite(int hashWhite) {
		this.hashWhite = hashWhite;
	}



	public int getHashBlack() {
		return hashBlack;
	}

	public void setHashBlack(int hashBlack) {
		this.hashBlack = hashBlack;
	}



	public int getContent() {
		return content;
	}
	
	public void setContent(int content) {
		this.content = content;
	}

	
	public String draw() {

		switch(this.content){
		case EMPTY: return " ";
		case WHITE: return "o";
		case BLACK: return "x";
		default: return "something nasty happend...";
		}
	}
}
