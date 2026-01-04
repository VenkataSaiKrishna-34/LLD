package TicTacToeDesign.Startegies;

import TicTacToeDesign.Board;
import TicTacToeDesign.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
