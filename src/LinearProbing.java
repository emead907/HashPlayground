/**
 * This method is for when using the linearProbing hash function
 * @author emilymead
 * @param <T>
 */
public class LinearProbing<T> extends HashTable<T>{
    /**
     * Creates a HashTable that will use linear probing
     */
    public LinearProbing(){
        super();
    }

    /**
     * The hash function for linear probing
     * @param key is the generic object that is stored in the hashObject
     * @param index is the index at which the search for the correct position is at
     * @return
     */
    public int hashFunction(T key, int index){
        int position = positiveMod(key.hashCode() + index, getTableSize());
        return(position);
    }
}
