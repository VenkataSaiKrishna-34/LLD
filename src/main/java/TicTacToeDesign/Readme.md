Requirements
-
- board of size nxn
- 2 - n players. Min 2 players, if < 2 throw exception. Let's not keep any checks on max no. of players
- each player should have a unique symbol
- on every player turn, player should provide their row and column numbers to mark their move
- Can have bot players as well
  - Maximum only one bot is allowed
- bot players can have difficulty level as well - Easy, Medium, Hard
- A Player can't quit the game in between
- Players can make the move in round-robin fashion.
- A Player can place their mark only on an unoccupied cell.
- The game should be able to display the current state of the board.
- Game ends when the Game has a winner or when the game is Draw
- Winning rules - Full Row or Full Column or Full Diagonal
- Players can undo the moves. (undo is not player specific, it's common for the whole game)


Entities
-
- Game
- Board
- Player (abstract class)
- HumanPlayer
- BotPlayer
- Symbol
- Cell
- Move

Enums
-
- GameStatus
- PlayerType
- CellState


