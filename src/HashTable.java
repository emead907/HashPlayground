import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.PrivateKey;

/**
 * This is the class that contains all the needed methods to create a HashTable using HashObjects
 * @author emilymead
 * @param <T>
 */
public abstract class HashTable<T> extends TwinPrimeGenerator{

    private HashObject<T>[] hashArray;
    private int tableSize;
    private int entrys;
    private long totalElements;

    public HashTable(){
        tableSize = twinPrime();
        hashArray = new HashObject[tableSize];
        entrys = 0;
    }

    /**
     * This method completes mod division and then makes sure the number is positive
     * @param dividend the frist int in the equation
     * @param divisor the second int in the equation
     * @return a positive int that is the mod of dividend and divisor
     */
    protected int positiveMod(int dividend, int divisor){
        int value = dividend % divisor;
        if(value < 0){
            value += divisor;
        }
        return value;
    }

    /**
     * @return the size of the table
     */
    public int getTableSize(){
        return this.tableSize;
    }

    /**
     * insert first checks if the object being inserted is a duplicate if it not then it inserts it into the
     * HashTable
     * @param object is the HashObject that is being inserted into the HashTable
     */
    public void insert(HashObject<T> object){
       // if(search(object.getKey())){
       //     object.increseFrequecy();
       // }
            totalElements++;
            for (int i = 0; i < tableSize; i++) {
                int j = hashFunction(object.getKey(), i);
                object.probeCountIncrece();
                if (hashArray[j] == null) {
                    hashArray[j] = object;
                    entrys++;
                    return;
                }
                else if(hashArray[j].equals(object.getKey())){
                    hashArray[j].increseFrequecy();
                    return;
                }

            }
    }

    /**
     * Searches through the HashTable by probing the slots that the key could be in to check and see if the HashObject
     * is a duplicate or not
     * @param key is the
     * @return true if the object is a duplicit or false if is the first time it has been seen
     */
       public boolean search(T key){
            int i = 0;
            int j = 0;
            while(i < getTableSize() || hashArray[j] == null){
                j = hashFunction(key, i);
                if(hashArray[j] == key){
                    return true;
                }
                i++;
            }
            return false;
        }

    /**
     * @return the amount of entrys in a HashTable
     */
        public int getEntrys(){
           return this.entrys;
        }

    /**
     * @return the current load factor of a HashTable
     */
        public double getLoadFactor(){
           return (double)entrys / tableSize;
        }

    /**
     * @return the number of elements.
     */
        public long getTotalElements(){
           return this.totalElements;
        }

    /**
     * gets the amount of dublicated HashObjects
     * @return the number of duplicates trying to be inserted into a HashTable
     */
    public long getDuplicteCount(){
           long count = 0;
           for(int i = 0; i < tableSize; i++){
                if(hashArray[i] != null){
                    count += hashArray[i].getFreqCount();
                }
           }
           return count;
        }

    /**
     * calculates the average number of probes for an entire HashTable
     * @return a double that is the average number of probes
     */
        public double probeAvg(){
            int count = 0;
            for(int i = 0; i < tableSize; i++){
                if(hashArray[i] != null){
                    count += hashArray[i].getProbeCount();
                }
            }
            return (double)count / entrys;
        }

    /**
     * The dump method creates a file and appends informations on each HashObject in the HashTable
     * @param filename - the name the new file will be
     * @throws FileNotFoundException
     */
        public void dump(String filename) throws FileNotFoundException {
            PrintStream ps = new PrintStream(new File(filename));
            for(int i = 0; i < tableSize; i++){
                if(hashArray[i] != null){
                    ps.append("Table["+i+"]: "+hashArray[i].toString() +"\n");
                }
            }
            System.setOut(ps);
            ps.close();
        }

    /**
     * This toString method returns a string containing the information for every 10 HashObjects in the HashTable
     * @return tableProp - the information of every 10 hashObjects
     */
    public String toString(){
           String tableProp = "";
            for(int i = 0; i < tableSize; i += 10){
                if(hashArray[i] != null){
                    tableProp += "Table["+i+"]: "+hashArray[i].toString() +"\n";
                }
            }
            return tableProp;
        }

    /**
     * The abstract hashFunction for hashing the hashObjects
     * @param key is the generic object that is stored in the hashObject
     * @param index is the index at which the search for the correct position is at
     * @return an int that corrisponds to the position that the hashObject will try to be inserted at
     */
    public abstract int hashFunction(T key, int index);
}