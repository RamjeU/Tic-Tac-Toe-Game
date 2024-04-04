import java.util.LinkedList;

// Class HashDictionary implementing the DictionaryADT interface
public class HashDictionary implements DictionaryADT {
    // LinkedList array to store Data objects
    private final LinkedList<Data>[] table;
    // Size of the hash table
    private int size;

    // Constructor for HashDictionary class
    public HashDictionary(int size) {
        this.size = size;
        // Initialize the hash table with the specified size
        table = new LinkedList[size];
        // Initialize each LinkedList in the hash table
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Method to add a record to the hash table
    public int put(Data record) throws DictionaryException {
        // Calculate the index for the record using the hash function
        int index = hashFunction(record.getConfiguration());
        // Check if the record already exists in the hash table
        for (Data data : table[index]) {
            if (data.getConfiguration().equals(record.getConfiguration())) {
                // If the record exists, throw a DictionaryException
                throw new DictionaryException();
            }
        }
        // If the record does not exist, add it to the hash table
        table[index].add(record);
        // Return 1 if a collision occurred, 0 otherwise
        return table[index].size() > 1 ? 1 : 0;
    }

    // Method to remove a record from the hash table
    public void remove(String config) throws DictionaryException {
        // Calculate the index for the record using the hash function
        int index = hashFunction(config);
        // Try to remove the record from the hash table
        boolean removed = table[index].removeIf(data -> data.getConfiguration().equals(config));
        // If the record was not found, throw a DictionaryException
        if (!removed) {
            throw new DictionaryException();
        }
    }

    // Method to get a record from the hash table
    public int get(String config) {
        // Calculate the index for the record using the hash function
        int index = hashFunction(config);

        // Search for the record in the hash table
        for (Data data : table[index]) {
            if (data.getConfiguration().equals(config)) {
                // If the record is found, return its score
                return data.getScore();
            }
        }
        // If the record is not found, return -1
        return -1;
    }

    // Method to get the number of records in the hash table
    public int numRecords() {
        int count = 0;
        // Count the number of records in each LinkedList in the hash table
        for (LinkedList<Data> list : table) {
            count += list.size();
        }
        // Return the total number of records
        return count;
    }

    // Hash function to calculate the index for a record
    private int hashFunction(String config) {
        int hash = 0;
        // Calculate the hash value for the record
        for (int i = 0; i < config.length(); i++) {
            hash = 87 * hash + config.charAt(i);
            hash %= table.length;
        }
        // Return the hash value
        return hash;
    }
}
