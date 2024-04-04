import java.util.Arrays;

// Class Configurations represents the game board and its configurations.
public class Configurations {

    // 2D array to represent the game board.
    private char[][] board;
    // The length of the sequence needed to win the game.
    private int lengthToWin;
    // The maximum level of the game tree that will be explored by the program.
    private int maxLevels;

    // Constructor for the Configurations class.
    // It initializes a new Configurations object with the specified board size, length to win, and maximum levels.
    public Configurations(int boardSize, int lengthToWin, int maxLevels) {
        this.board = new char[boardSize][boardSize];
        // Initialize the game board with empty spaces.
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = ' ';
            }
        }
        this.lengthToWin = lengthToWin;
        this.maxLevels = maxLevels;
    }

    // Method to create a new HashDictionary.
    public HashDictionary createDictionary() {
        return new HashDictionary(7001);
    }

    // Method to check if the current board configuration is repeated in the hash table.
    public int repeatedConfiguration(HashDictionary hashTable) {
        String config = this.boardToString();
        return hashTable.get(config);
    }

    // Method to add the current board configuration and a given score to the hash table.
    public void addConfiguration(HashDictionary hashDictionary, int score) {
        String config = this.boardToString();
        try {
            hashDictionary.put(new Data(config, score));
        } catch (DictionaryException e) {
            e.printStackTrace();
        }
    }

    // Method to save a play at a given position in the board.
    public void savePlay(int row, int col, char symbol) {
        this.board[row][col] = symbol;
    }

    // Method to check if a square in the board is empty.
    public boolean squareIsEmpty(int row, int col) {
        return this.board[row][col] == ' ';
    }

    // Method to check if a player wins.
    public boolean wins(char symbol) {
        for (int i = 0; i < board.length; i++) {
            if (checkLine(board[i], symbol) || checkLine(getColumn(i), symbol)) {
                return true;
            }
        }

        // Check diagonals
        if (checkLine(getDiagonal(true), symbol) || checkLine(getDiagonal(false), symbol)) {
            return true;
        }

        return false;
    }

    // Helper method to check if a line (row, column, or diagonal) contains a winning sequence.
    private boolean checkLine(char[] line, char symbol) {
        int count = 0;
        for (char c : line) {
            if (c == symbol) {
                count++;
                if (count == lengthToWin) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    // Helper method to get a column from the board.
    private char[] getColumn(int index) {
        char[] column = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[i][index];
        }
        return column;
    }

    // Helper method to get a diagonal from the board.
    private char[] getDiagonal(boolean isMainDiagonal) {
        char[] diagonal = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            diagonal[i] = isMainDiagonal ? board[i][i] : board[i][board.length - 1 - i];
        }
        return diagonal;
    }

    // Method to check if the game is a draw.
    public boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to evaluate the board and returns an integer based on the game state.
    public int evalBoard() {
        if (this.wins('O')) {
            return 3;
        } else if (this.wins('X')) {
            return 0;
        } else if (this.isDraw()) {
            return 2;
        } else {
            return 1;
        }
    }

    // Helper method to convert the board to a string.
    private String boardToString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char cell : row) {
                sb.append(cell);
            }
        }
        return sb.toString();
    }
}
