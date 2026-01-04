package TicTacToeDesign.Player;

import TicTacToeDesign.Move;
import TicTacToeDesign.Symbol;

public abstract class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType type;

    public Player(int id, String name, Symbol symbol, PlayerType type) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public abstract Move makeMove();
}
