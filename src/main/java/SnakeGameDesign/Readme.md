
Requirements:
- 
- Standard square board size with 100 cells. 1 - 100 numbers.
- Number of Snakes and Ladders should be configurable from the client side while creating the Game
- Game should support multiple players
- Use random number for every dice role. consider the standard dice numbers 1 - 6.
- if a player rolls 6, he/she should get another chance to roll the dice.
- A player is considered winner, if he/she can reach 100th cell in his last dice roll.
- Once the game has a winner, its considered the game is completed.


Entities
-
- Game
- Board
- Dice
- Snake
- Ladder
- Player

Consider Snake and Ladder as board entities. Keep it easy to extend it to other entities as well.

---


```
enum BoardEntityType {
    SNAKE,
    LADDER
}
```

```
class BoardEntity {
    attributes:
    start : int
    end : int
    entityType : BoardEntityType
}
```
```
class Snake extends BoardEntity {
}
```
```
class Ladder extends BoardEntity {
}
```

```
class Dice {
    attributes:
    sides : int
    
    methods:
    rollDice() : int
}
```

```
class Player {
    attributes:
    id : int
    name : String
    currentPosition : int
}
```

```
class Board {

    attributes:
    size : int
    entities : List<BoardEntity>   //contains Snakes and Ladders start and end positions
    jumps : Map<Integer, Integer>  //<startPosition, endPosition> of the board entities

    methods:
    getFinalPosition() : int     //uses jumps map to get the final position considering the board entities
}
```

```
enum GameStatus {
    NOT_STARTED,
    IN_PROGRESS,
    FINISHED
}
```

```
class Game {
    attributes:
    board : Board
    dice : Dice
    players : List<Player>
    currentPlayerIndex : int
    winner : Player
    gameStatus : GameStatus

    methods:
    startGame() : void
    takeTurn() : void
    checkWinner() : Boolean
}
```