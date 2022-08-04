package gameplay;

import connectFour.*;

public class Game {
	
	public static void main(String[] args) {
		MiniMax MM = new MiniMax();
		State game = new State(new int[][] {{0,0,0,-1,0,0,0},
											{0,-1,-1,1,0,1,0},
											{1,1,1,-1,0,1,0},
											{-1,-1,-1,1,0,-1,0},
											{-1,1,1,-1,0,1,0},
											{-1,-1,1,1,1,-1,0}}, -1);
		Move nextMove = MM.getBestMove(game);
		
		for(int[] row: game.getGame()) {
			for(int bit: row) {
				System.out.print(bit + "\t");
			}
			System.out.println();
		}
		System.out.println("Best Move: " + nextMove.getColumn());
		System.out.println("Score of Move: " + nextMove.getScore());
	}

}
