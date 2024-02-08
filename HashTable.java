import java.util.LinkedList;

public class HashTable {
    private LinkedList<String>[] table;
    private int size, maxChained, collisions; // used for metrics

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++)
            table[i] = new LinkedList<String>();
        size = maxChained = collisions = 0;
    }

    // return the index position based on the hash function for the data
    private int hashFunction1(String data) {
        
    }

    // return the index position based on the hash function for the data
    private int hashFunction2(String data) {
        // create a second hash function to test with
        
    }

    // insert the data into the hash table based on your hash function and use
    // linear probing to resolve collisions
    // include updates to metrics variables
    public void insert(String data) {
        int hash = hashFunction1(data);
        int hash = hashFunction2(data);
        if(table[hash].isEmpty()) 
            size++;
        else 
            collisions++;
        table[hash].add(data);
    }

    public void capacity() {
        size = 0;
        maxChained = 0;
        collisions = 0; // reset metrics

       LinkedList<String>[] oldTable = table;
       table = new LinkedList[oldTable.length*2];
       for(int i = 0; i < table.length; i++)
           table[i] = new LinkedList<String>();

       for(LinkedList<String> list: oldTable)
           for(String s: list)
               insert(s);
    }

    // returns the number of holes in the hash table
    public int holes() {
        return table.length - size;
    }


    // returns the number of collisions this heap has encountered
    public int collisions() {
        return collisions;
    }

    // returns the maximum number of elements that are chained to a position in the
    // hash table
    public int maxChained() {
        for (int i = 0; i < table.length; i++) {
            maxChained = Math.max(table[i].size(), maxChained);
        }
        return maxChained;
    }

    public void displayTable() { // 5 entries displayed per line
        String result = "\n\t\tTable:\n[Keys]\t\t\t[Values]";
        for (int i = 0; i <= table.length - 1; i++)
            result += "\n[" + i + "]\t\t\t" + (i < 10 ? "\t" : "") + table[i];
        System.out.println(result);
    }

}
