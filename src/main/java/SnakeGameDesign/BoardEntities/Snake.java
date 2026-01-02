package SnakeGameDesign.BoardEntities;

import SnakeGameDesign.exceptions.InvalidBoardEntityArgumentException;

public class Snake extends BoardEntity {
    public Snake(int start, int end) throws Exception {
        super(start, end, BoardEntityType.SNAKE);
        if(start <= end) {
            throw new InvalidBoardEntityArgumentException("Snake head must be at a higher positon");
        }
    }
}
