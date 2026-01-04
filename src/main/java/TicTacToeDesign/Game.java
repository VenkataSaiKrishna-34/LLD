package TicTacToeDesign;

import TicTacToeDesign.Player.Player;
import TicTacToeDesign.Player.PlayerType;
import TicTacToeDesign.Startegies.WinningStrategy;
import TicTacToeDesign.Startegies.WinningStrategyImpl;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private Board board;
    private List<Player> players;
    private GameState state;
    private int currentPlayerIndex;
    private List<Move> moves;
    private Player winner;
    private WinningStrategy winningStrategy;

    public Game(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
        this.state = GameState.NOT_STARTED;
        this.currentPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.winningStrategy = new WinningStrategyImpl();
    }

    public static class Builder {
        private int boardSize;
        private List<Player> players;

        public Builder setBoardSize(int size) {
            this.boardSize = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean validate() {
            int botCount = 0;

            if(players.size() < 2) {
                return false;
            }

            for(Player player : players) {
                if(player.getType() == PlayerType.BOT) {
                    botCount++;
                }
                if(botCount > 1) return false;
            }

            return true;
        }

        public Game build() {
            if(!validate()) {
                // TODO: Throw an exception
                return null;
            }
            return new Game(boardSize, players);
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void startGame() {
        state = GameState.IN_PROGRESS;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void displayBoard() {
        board.displayBoard();
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        return row >= 0 && row < board.getSize() && col >= 0 && col <= board.getSize() &&
                board.getGrid().get(row).get(col).getState().equals(CellState.EMPTY);
    }

    private void updateGameState(Move move, Player currentPlayer) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        Cell finalCell = board.getGrid().get(row).get(col);
        finalCell.setState(CellState.FILLED);
        finalCell.setSymbol(currentPlayer.getSymbol());

        move.setCell(finalCell);
        moves.add(move);

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private boolean checkWinner(Move move) {
        return winningStrategy.checkWinner(board, move);
    }

    public void makeMove() {
        Player currentPlayer = players.get(currentPlayerIndex);
        Move move = currentPlayer.makeMove();

        if(!validateMove(move)) {
            // TODO: throw an exception
            return;
        }

        updateGameState(move, currentPlayer);

        if(checkWinner(move)) {
            state = GameState.SUCCESS;
            winner = currentPlayer;
        } else if(moves.size() == board.getSize() * board.getSize()) {
            state = GameState.DRAW;
        }
    }


    // TODO: Implement Undo
}
