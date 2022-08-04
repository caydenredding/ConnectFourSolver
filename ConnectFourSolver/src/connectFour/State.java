package connectFour;

public class State {
	
	private int[][] state = new int[6][7];
	// 0 is empty, 1 is player 1 and -1 is player 2
	
	public int firstMove;
	
	public State() {		
	}
	
	public State(int[][] state, int firstMove) {
		this.state = state;
		this.firstMove = firstMove;
	}
	
	public int emptyCount() {
		int count = 0;
		for (int[] line: state) {
			for (int bit : line) {
				if (bit == 0) count++;
			}
		}
		return count;
	}
	
	public int getFirst() {
		return firstMove;
	}
	
	public int[][] getGame() {
		int[][] out = new int[6][7];
		for(int i=0; i<state.length; i++) {
			for (int j=0; j<state[i].length; j++) {
				out[i][j] = state[i][j];
			}
		}
		return out;
	}
	
	public boolean addChip (int player, int column) {
		 for (int i=5; i>=0; i--) {
			 if(state[i][column] == 0) {
				 state[i][column] = player;
				 return true;
			 }
		 }
		return false;
	}
	
	public void removeChip(int column) {
		for (int i=5; i>=0; i--) {
			if (state[i][column] != 0) {
				state[i][column] = 0;
				return;
			}
		}
	}
	
	public boolean canAddChip (int column) {
		if(state[0][column] == 0) {
			 return true;
		 }
		return false;
	}
	

	
	public int checkWin() {		//check whether or not a player has won
		int win = checkVerticalWin();
		if (win != 0) return win;
		win = checkHorizontalWin();
		if (win != 0) return win;
		win = checkDiagonalLeftWin();
		if (win != 0) return win;
		win = checkDiagonalRightWin();
		if (win != 0) return win;
		
		return 0;
	}
	
	private int checkVerticalWin() {    //checks for any win in the vertical direction
		for (int i=0; i<state[0].length; i++) {
			if (state[3][i] != 0 && state[3][i] == state [2][i]) {
				if ((state[1][i] == state[3][i] && state[4][i] == state[3][i]) || (state[1][i] == state[3][i] && state[0][i] == state[3][i]) || (state[4][i] == state[3][i] && state[5][i] == state[3][i])) {
					return state[3][i];
				}
			}
		}
		return 0;
	}
	
	private int checkHorizontalWin() {	//checks for any win the horizontal direction
		for (int[] row : state) {
			int count = 1;
			if(row[3] != 0) {
				for(int i=2; i>=0; i--) {
					if(row[i]==row[3]) count++;
					else {
						break;
					}
				}
				for(int i=4; i<7; i++) {
					if(row[i]==row[3]) count++;
					else {
						break;
					}
				}
			}
			if (count >=4) return row[3];
		}
		return 0;
	}
	
	private int checkDiagonalLeftWin() {// checks any win in \ direction
		for (int i=1; i<7; i++) {
			int count = 1;
			if(state[3][i] != 0) {
				for(int j=2; j>=0 && i+j>2; j--) {
					if(state[j][i+j-3]==state[3][i]) count++;
					else {
						break;
					}
				}
				if(i<6 && state[4][i+1]==state[3][i]) {
					count++;
					if(i<5 && state[5][i+2]==state[3][i]) count++;
				}else {
					
				}
				
			}
			if (count >=4) return state[3][i];
		}
		return 0;
	}
	
	private int checkDiagonalRightWin() {//checks any win in / direction
		for (int i=0; i<6; i++) {
			int count = 1;
			if(state[3][i] != 0) {
				for(int j=2; j>=0 && i-j<4; j--) {
					if(state[j][i-j+3]==state[3][i]) count++;
					else {
						break;
					}
				}
				if(i>0 && state[4][i-1]==state[3][i]) {
					count++;
					if(i>1 && state[5][i-2]==state[3][i]) count++;
				}else {
					
				}
				
			}
			if (count >=4) return state[3][i];
		}
		return 0;
	}
	
	
//	public static void main(String[] args) {
//		State testOne = new State(new int[][] {	{0,0,0,0,0,0,0},
//												{1,0,0,0,0,0,0},
//												{1,1,-1,1,-1,-1,0},
//												{1,1,1,-1,-1,1,0},
//												{1,-1,1,-1,1,-1,0},
//												{-1,1,1,-1,-1,1,0}});
//		System.out.println(testOne.checkDiagonalLeftWin());
//		System.out.println(testOne.checkDiagonalRightWin());
//		System.out.println(testOne.checkHorizontalWin());
//		System.out.println(testOne.checkVerticalWin());
//		System.out.println(testOne.checkWin());
//		
//		testOne.addChip(-1, 1);
//		for (int[] row : testOne.state) {
//			for (int bit : row) {
//				System.out.print(bit);
//			}
//			System.out.println();
//		}
//
//		}

}
