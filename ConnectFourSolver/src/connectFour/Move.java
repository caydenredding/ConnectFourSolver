package connectFour;

public class Move {
	int column, score;
	
	public Move (int score, int column) {
		this.column = column;
		this.score = score;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getScore() {
		return score;
	}
	

}
