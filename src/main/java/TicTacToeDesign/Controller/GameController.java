package TicTacToeDesign.Controller;

import TicTacToeDesign.Game;
import TicTacToeDesign.GameState;
import TicTacToeDesign.Player.Player;

import  java.util.List;

public class GameController {

    public Game createGame(int boardSize, List<Player> players) {
           return Game.getBuilder()
                   .setBoardSize(boardSize)
                   .setPlayers(players)
                   .build();
    }

    public void startGame(Game game) {
        game.startGame();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameState getGameState(Game game) {
        return game.getState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undoMove(Game game) {

    }
}
