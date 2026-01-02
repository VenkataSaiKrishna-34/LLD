package SnakeGameDesign.BoardEntities;

public abstract class BoardEntity {
    private final int start;
    private final int end;
    private final BoardEntityType entityType;

    public BoardEntity(int start, int end, BoardEntityType entityType){
        this.start = start;
        this.end = end;
        this.entityType = entityType;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public BoardEntityType getEntityType() {
        return entityType;
    }
}
