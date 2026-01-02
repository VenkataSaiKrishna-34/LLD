package SnakeGameDesign;

import SnakeGameDesign.BoardEntities.BoardEntity;

import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private GameStatus status;
    private Player winner;
    private int currentPlayerIndex;

    public Game(Builder builder) {
        board = builder.board;
        players = builder.players;
        dice = builder.dice;
        status = GameStatus.NOT_STARTED;
        winner = null;
        currentPlayerIndex = 0;
    }

    public void startGame() {
        if (players.size() < 2) {
            System.out.println("Cannot Start Game. At least 2 players are required to start the game");
            return;
        }

        status = GameStatus.RUNNING;
        while (status == GameStatus.RUNNING) {
            Player currentPlayer = players.get(currentPlayerIndex);
            takeTurn(currentPlayer);
            currentPlayerIndex = (currentPlayerIndex + 1)%players.size();
        }

        System.out.println("Game Finished!!");
        if(winner != null) {
            System.out.println("The Winner is = " + winner.getName());
        }
    }

    private void takeTurn(Player player) {
        int roll = dice.rollDice();
        int currentPosition = player.getCurrentPosition();
        int nextPosition = currentPosition + roll;
        int finalPosition = board.getFinalPosition(nextPosition);

        if(finalPosition > board.getSize()) {
            return;
        }

        if (finalPosition > nextPosition) {
            System.out.printf("Wow! %s found a ladder at %d and claimed to %d. \n", player.getName(), nextPosition, finalPosition);
        } else if(finalPosition < nextPosition) {
            System.out.printf("Oh no! %s was bitten by a snake at %d and slided to %d. \n", player.getName(), nextPosition, finalPosition);
        } else {
            System.out.printf("%s moved from %d to %d.\n", player.getName(), currentPosition, finalPosition);
        }

        player.setCurrentPosition(finalPosition);
        if(finalPosition == board.getSize()){
            winner = player;
            status = GameStatus.FINISHED;
            return;
        }

        if(roll == 6) {
            System.out.printf("%s rolled a 6 and gets another turn!\n", player.getName());
            takeTurn(player);
        }
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private Dice dice;

        public Builder setBoard(int boardDimension, List<BoardEntity> boardEntities) {
            this.board = new Board(boardDimension, boardEntities);
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game buid() {
            if(board == null || players == null || dice == null) {
                throw new IllegalStateException("Board, Players, and Dice must be set");
            }

            return new Game(this);
        }
    }
}
