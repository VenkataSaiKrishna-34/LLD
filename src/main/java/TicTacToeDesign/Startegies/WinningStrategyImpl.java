package TicTacToeDesign.Startegies;

import TicTacToeDesign.Board;
import TicTacToeDesign.Move;
import TicTacToeDesign.Symbol;

import java.util.HashMap;
import java.util.Map;

public class WinningStrategyImpl implements WinningStrategy {
    Map<Integer, Map<Symbol, Integer>> rowMap;
    Map<Integer, Map<Symbol, Integer>> colMap;
    Map<Symbol, Integer> diagonalMap;
    Map<Symbol, Integer> antiDiagonalMap;

    public WinningStrategyImpl() {
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        diagonalMap = new HashMap<>();
        antiDiagonalMap = new HashMap<>();
    }

    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Symbol symbol = move.getCell().getSymbol();

        rowMap.putIfAbsent(row, new HashMap<>());
        rowMap.get(row).put(symbol, rowMap.get(row).getOrDefault(symbol, 0) + 1);

        colMap.putIfAbsent(col, new HashMap<>());
        colMap.get(col).put(symbol, colMap.get(col).getOrDefault(symbol, 0) + 1);

        if(row == col) {
            diagonalMap.put(symbol, diagonalMap.getOrDefault(symbol, 0) + 1);
        }

        if(row + col == board.getSize()) {
            antiDiagonalMap.put(symbol, antiDiagonalMap.getOrDefault(symbol, 0) + 1);
        }

        return rowMap.get(row).get(symbol) == board.getSize() ||
                colMap.get(col).get(symbol) == board.getSize() ||
                diagonalMap.getOrDefault(symbol, 0) == board.getSize() ||
                antiDiagonalMap.getOrDefault(symbol,0) == board.getSize();
    }
}
