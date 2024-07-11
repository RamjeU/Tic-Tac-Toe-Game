# Tic-Tac-Toe-Game

## Overview
This Java program allows you to play a game of Tic-Tac-Toe against the computer. The game board can have a customizable number of rows and columns, and the winning condition can be set to a specific number of consecutive tiles.

## Features
- **Customizable Board Size:** Set the size of the board to any desired dimensions.
- **Adjustable Winning Length:** Specify the number of consecutive tiles required to win the game.
- **AI Opponent:** Play against a computer opponent that uses a configurable depth-limited game tree to determine its moves.
- **Graphical Interface:** Interactive graphical user interface to play the game.

## Classes and Their Functions

### Configurations
Represents the game board and its configurations.

- **Constructor:** Initializes the game board, the length to win, and the maximum levels of the game tree.
- **createDictionary:** Creates a new hash table for storing board configurations.
- **repeatedConfiguration:** Checks if the current board configuration is repeated in the hash table.
- **addConfiguration:** Adds the current board configuration and a given score to the hash table.
- **savePlay:** Saves a play at a given position on the board.
- **squareIsEmpty:** Checks if a square on the board is empty.
- **wins:** Checks if a player has won the game.
- **isDraw:** Checks if the game is a draw.
- **evalBoard:** Evaluates the board and returns an integer based on the game state.

### Data
Represents the records stored in the HashDictionary.

- **Constructor:** Initializes the Data object with a configuration and score.
- **getConfiguration:** Returns the stored configuration.
- **getScore:** Returns the stored score.

### HashDictionary
Implements a hash table to store board configurations and their scores.

- **Constructor:** Initializes the hash table with a specified size.
- **put:** Adds a record to the hash table.
- **remove:** Removes a record from the hash table.
- **get:** Retrieves a score from the hash table based on a configuration.
- **numRecords:** Returns the number of records in the hash table.

### Play
Main class to run the game, creating a graphical user interface for the Tic-Tac-Toe game.

- **Constructor:** Initializes the game board and sets up the GUI.
- **main:** Entry point to run the game.
- **ClickHandler:** Handles user clicks on the game board, processes the player's move, and computes the computer
