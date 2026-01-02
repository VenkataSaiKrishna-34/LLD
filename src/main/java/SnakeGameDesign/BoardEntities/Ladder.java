package SnakeGameDesign.BoardEntities;

import SnakeGameDesign.exceptions.InvalidBoardEntityArgumentException;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) throws Exception {
        super(start, end, BoardEntityType.LADDER);
        if (start >= end) {
            throw new InvalidBoardEntityArgumentException("Ladder start must be at a lower position");
        }
    }
}
