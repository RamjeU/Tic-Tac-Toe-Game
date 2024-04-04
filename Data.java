// Class Data represents the records that will be stored in the HashDictionary.
public class Data {
    // Instance variable 'config' to store the configuration of the game board.
    private String config;
    // Instance variable 'score' to store the score of the game.
    private int score;

    // Constructor for the Data class.
    // It initializes a new Data object with the specified configuration and score.
    public Data(String config, int score) {
        this.config = config;
        this.score = score;
    }

    // Method 'getConfiguration' returns the configuration stored in this Data object.
    public String getConfiguration() {
        return this.config;
    }

    // Method 'getScore' returns the score stored in this Data object.
    public int getScore() {
        return this.score;
    }
}
