/**
 * This is method is for creating a Hashtable that will use double hashing
 * @author emilymead
 * @param <T>
 */

public class DoubleHashing<T> extends HashTable<T>{
    /**
     * Creates a HashTable that will use double hashing
     */
    public DoubleHashing(){
        super();
    }

    /**
     * The hash function for double hashing
     * @param key is the generic object that is stored in the hashObject
     * @param index is the index at which the search for the correct position is at
     * @return
     */
    public int hashFunction(T key, int index){
        int h1 = positiveMod(key.hashCode(), getTableSize());
        int h2 = 1 + (positiveMod(key.hashCode(), getTableSize() - 2));
        int h3 = positiveMod(h1 + (index * h2), getTableSize());
        return h3;
    }
}
