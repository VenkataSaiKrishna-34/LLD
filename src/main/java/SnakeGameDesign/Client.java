package SnakeGameDesign;

import SnakeGameDesign.BoardEntities.BoardEntity;
import SnakeGameDesign.BoardEntities.Ladder;
import SnakeGameDesign.BoardEntities.Snake;

import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        List<BoardEntity> boardEntities = List.of(
                new Snake(17, 7), new Snake(54, 34),
                new Ladder(3, 38), new Ladder(24, 33)
        );

        List<Player> players = List.of(
                new Player(1, "player-1"),
                new Player(2, "player-2"),
                new Player(3, "player-3")
        );

        Game game = new Game.Builder()
                .setBoard(100, boardEntities)
                .setPlayers(players)
                .setDice(new Dice(6))
                .buid();

        game.startGame();
    }

}
