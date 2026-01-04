package TicTacToeDesign.Client;

import TicTacToeDesign.Controller.GameController;
import TicTacToeDesign.Game;
import TicTacToeDesign.GameState;
import TicTacToeDesign.Player.HumanPlayer;
import TicTacToeDesign.Player.Player;
import TicTacToeDesign.Player.PlayerType;
import TicTacToeDesign.Symbol;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();


        //TODO: I think we can use Builder patter in the player class
        Player p1 = new HumanPlayer(1, "Player-1", new Symbol('X'), PlayerType.HUMAN);
        Player p2 = new HumanPlayer(2, "Player-2", new Symbol('O'), PlayerType.HUMAN);
//        Player p3 = new HumanPlayer(3, "Player-3", new Symbol('B'), PlayerType.BOT);

        Game game =  gameController.createGame(3, List.of(p1, p2));
        gameController.startGame(game);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            gameController.makeMove(game);
            gameController.displayBoard(game);
        }

        if(gameController.getGameState(game).equals(GameState.DRAW)) {
            System.out.println("GAME DRAW");
        } else if(gameController.getGameState(game).equals(GameState.SUCCESS)) {
            System.out.println("Wohoo The Winner is = " + gameController.getWinner(game).getName());
        }
    }
}
