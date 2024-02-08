
public class TestHashTable
{
    public static void main(String[] args)
    {
        // unique values
        System.out.println("\n\nhashFunction1 -> hashes based off ??? \nhashFunction2 -> hashes based off ???\n");
        System.out.println("\tPart 1 - Unique Values");
        HashTable h = helper(new String[]{"Bennett", "Troy", "Shiloh", "Brennan", "Priscilla", "Angie", "Elian", "Destinee", "Livia", "Kinley", "Donald", "Bradley", "Moriah"}, 20);

        // duplicate values forcing collisions
        System.out.println("\tPart 2 - Duplicate Values (forcing collisions)");
        helper(new String[]{"Marcia", "Marcia", "Marcia", "Florczak", "Florczak", "Florczak"},10);

        // increasing capacity and rehashing old values into new table
        System.out.println("\tPart 3 - Rehashing Part 1 with doubled capacity");
        h.capacity();
        display(h);

        // hashing more values than initial table capacity
        System.out.println("\tPart 4 - Hashing more values than initial table capacity");
        helper(new String[]{"Vex'ahlia","Percival","Pike","Vax'ildan","Keyleth","Scanlan","Grog"},2);
    }

    public static HashTable helper(String[] names, int capacity)
    {
        HashTable h = new HashTable(capacity);
        for(String n: names)
            h.insert(n);
        display(h);
        return h;
    }

    public static void display(HashTable h)
    {
        h.displayTable();
        System.out.println("holes: " + h.holes());
        System.out.println("collisions: " + h.collisions());
        System.out.println("max chained elements: " + h.maxChained()+"\n");
    }
}
