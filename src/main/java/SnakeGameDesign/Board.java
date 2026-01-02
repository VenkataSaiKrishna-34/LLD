package SnakeGameDesign;

import SnakeGameDesign.BoardEntities.BoardEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final List<BoardEntity> boardEntities;
    private final Map<Integer, Integer> jumps;

    public Board(int dimension, List<BoardEntity> boardEntities) {
        this.size = dimension;
        this.boardEntities = boardEntities;
        this.jumps = new HashMap<>();

        for(BoardEntity entity : boardEntities) {
            jumps.put(entity.getStart(), entity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public List<BoardEntity> getBoardEntities() {
        return boardEntities;
    }

    public int getFinalPosition(int position) {
        return jumps.getOrDefault(position, position);
    }
}
