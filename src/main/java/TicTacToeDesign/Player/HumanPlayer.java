package TicTacToeDesign.Player;

import TicTacToeDesign.Cell;
import TicTacToeDesign.Move;
import TicTacToeDesign.Symbol;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private int coins;
    private int level;
    private Scanner scanner;

    public HumanPlayer(int id, String name, Symbol symbol, PlayerType type) {
        super(id, name, symbol, type);
        this.coins = 100;
        this.level = 0;
        this.scanner = new Scanner(System.in);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Move makeMove() {
        System.out.println(getName() + "'s Turn: ");
        System.out.println("Please enter the row in which you want to make the move : ");
        int row = scanner.nextInt();

        System.out.println("Please enter the column in which you want make the move: ");
        int column = scanner.nextInt();

        return new Move(new Cell(row, column), this);
    }
}
