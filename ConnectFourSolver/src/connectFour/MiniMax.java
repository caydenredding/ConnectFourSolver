package connectFour;

public class MiniMax {
	
	public MiniMax() {
		
	}
	
	public Move getBestMove(State state) {
		return getBestMove(state, -1);
	}
	
	private Move getBestMove(State state, int column) {
		int remainingTurns = state.emptyCount();
		int winner = state.checkWin();
		if (winner != 0) {
			return (new Move((remainingTurns)*winner*state.getFirst(), column));
		} else if (remainingTurns == 0) {
			return new Move(0, column);
		}
		Move out = null;
		if (remainingTurns%2 ==0) {
			Move[] maxMoves = new Move[7];
			for (int i=0; i<7; i++) {
				if (state.canAddChip(i)) {
					maxMoves[i] = getBestMove(addTempChip(state,state.getFirst(),i), i);
				}
			}
			for (Move move: maxMoves) {
				if(move != null && (out == null || move.getScore() > out.getScore())) {
					out = move;
				}
			}
		}else {
			Move[] minMoves = new Move[7];
			for (int i=0; i<7; i++) {
				if (state.canAddChip(i)) {
					minMoves[i] = getBestMove(addTempChip(state,state.getFirst()*-1,i), i);
				}
			}
			for (Move move: minMoves) {
				if((move != null && (out == null || move.getScore() < out.getScore()))) {
					out = move;
				}
			}
		}
		if (column == -1) return out;
		return new Move(out.getScore(), column);
	}
	
	private State addTempChip(State state, int player,int column) {
		State newState = new State(state.getGame().clone(), state.getFirst());
		newState.addChip(player, column);
		return newState;
	}

}
