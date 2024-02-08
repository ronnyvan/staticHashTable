import java.util.LinkedList;
public class HashTable<V> {
    private LinkedList<V>[] table;
    private int size, collisions, maxChained;

    public HashTable(int capacity){
        table = new LinkedList[capacity];
        populate(table);
        size = collisions = maxChained = 0;
    }
    public void populate(LinkedList<V>[] table){
        for(int i = 0; i < table.length; i++)
            table[i] = new LinkedList<V>();
    }
    public int hashFunction1(V data){
        return (data instanceof String)
                ? Character.toLowerCase(((String) data).charAt(0)) % table.length
                : data.hashCode();
    }
    public int hashFunction2(V data){
        return (data instanceof String)
                ? ((String) data).chars().sum() % table.length
                : data.hashCode();
    }

    public void insert(V data){
        int hash = hashFunction1(data);
        //int hash = hashFunction2(data);
        if(table[hash].isEmpty()) size++;
        else collisions++;
        table[hash].add(data);
    }
    public void capacity(){
        size = collisions = maxChained = 0;
        LinkedList<V>[] oldTable = table;
        table = new LinkedList[oldTable.length*2];
        populate(table);

        for(LinkedList<V> bucket: oldTable)
            for(V data: bucket)
                insert(data);
    }
    public int holes() { return table.length - size; }
    //returns the number of collisions this heap has encountered
    public int collisions() { return collisions; }
    //returns the maximum number of elements that are chained to a position in the hash table
    public int maxChained() {
        for(LinkedList<V> bucket : table)
            maxChained = Math.max(maxChained, bucket.size());
        return maxChained;
    }

    public void displayTable() {
        String result = "\n\t\tTable:\n[Keys]\t\t\t[Values]";
        for (int i = 0; i <= table.length - 1; i++)
            result += "\n[" + i + "]\t\t\t" + (i < 10 ? "\t" : "") + table[i].toString();
        System.out.println(result);
    }
}
