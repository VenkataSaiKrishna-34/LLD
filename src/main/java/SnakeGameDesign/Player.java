package SnakeGameDesign;

public class Player {
    private final int id;
    private String name;
    private int currentPosition;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.currentPosition = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
