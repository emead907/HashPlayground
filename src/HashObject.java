public class HashObject<T> {
    /**
     * This method creates HashObjects which are used to build a hashTable
     * @author emily mead
     */
    private int probeCount;
    private int freqCount;
    private T key;

    public HashObject(T key){
        this.probeCount = 0;
        this.freqCount = 0;
        this.key = key;

    }

    /**
     * @return the key of the HashObject
     */
    public T getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return String.valueOf(key) + " " + freqCount + " " + probeCount;
    }

    @Override
    public boolean equals(Object object){
        return key.equals(object);
    }

    /**
     * Increases the freqCount varible by 1
     */
    public void increseFrequecy(){
        this.freqCount++;
    }

    /**
     *
     * @return the freqCount
     */
    public int getFreqCount(){
        return this.freqCount;
    }

    /**
     * increases the probeCount varible by 1
     */
    public void probeCountIncrece(){
        probeCount++;
    }

    /**
     *
     * @return the probeCount
     */
    public int getProbeCount(){
        return this.probeCount;
    }



}
