package SnakeGameDesign;

import java.util.random.*;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int rollDice() {
        return (int)(Math.random()*sides) + 1;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
