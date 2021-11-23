import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the driver class. It tests the hashFunctions by outputting three differnt
 * outputs. This class takes into count the data type of the key for the hashObjects
 * as well has the loadFactor and the debug level
 */
public class HashtableTest{

    public static void main(String arg[]){
        int inputType = 0;
        String input = "";
        double loadFactor = 0;
        int debugLevel = 0;

        if(Integer.parseInt(arg[0]) == 1){
            inputType = 1;
            input = "random-numbers";
        }
        else if(Integer.parseInt(arg[0]) == 2){
            inputType = 2;
            input = "system-time";
        }
        else if(Integer.parseInt(arg[0]) == 3){
            inputType = 3;
            input = "word-list";
        }
        else {
            System.out.println("Input type must be 1, 2, or 3");
            System.out.println("Usage: java HashtableTest <input type> <load factor> [<debug level>]");
            System.exit(1);
        }
        if(Double.parseDouble(arg[1]) < 0 && Double.parseDouble(arg[1]) > 1){
            System.out.println("Load factor must be a double between 0 and 1");
            System.out.println("Usage: java HashtableTest <input type> <load factor> [<debug level>]");
            System.exit(1);
        }
        else{
            loadFactor = Double.parseDouble(arg[1]);
        }

        if(arg.length == 3){
            if(Integer.parseInt(arg[2]) == 1){
                debugLevel = 1;
            }
            else if(Integer.parseInt(arg[2]) == 2){
                debugLevel = 2;
            }
        }
        //Creating the two hashTables one for linear probing and the other for double hashing
        LinearProbing lHash = new LinearProbing();
        DoubleHashing dHash = new DoubleHashing();
        //This is for if the input type is word-list
        if(inputType == 3){
            //key type is a string from the word list
            File textFile = new File("word-list");
            try {
                Scanner wordFileScanner = new Scanner(textFile);
                while (wordFileScanner.hasNextLine() && lHash.getLoadFactor() < loadFactor){
                    String word = wordFileScanner.nextLine();
                    HashObject object = new HashObject(word);
                    HashObject object1 = new HashObject(word);
                    lHash.insert(object);
                    dHash.insert(object1);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //This is for when the input type is system-time
        else if(inputType == 2){
            //system time
            while (lHash.getLoadFactor() < loadFactor){
                long time = System.currentTimeMillis();
                HashObject object = new HashObject(time);
                HashObject object1 = new HashObject(time);
                lHash.insert(object);
                dHash.insert(object1);
            }
        }
        //this is for when the input type is for random numbers
        else if(inputType == 1){
            //random numbers
            while (lHash.getLoadFactor() < loadFactor){
                Random random = new Random();
                int number = random.nextInt();
                HashObject object = new HashObject(number);
                HashObject object1 = new HashObject(number);
                lHash.insert(object);
                dHash.insert(object1);
            }
        }


        //Debug level 0
        if(debugLevel == 0){
            System.out.println("HashtableTest: Twin prime table size found in the range [95500...96000]: " + lHash.getTableSize());
            System.out.println("\nHashtableTest: Data source type --> " + input);
            System.out.println("\nHashtableTest: Using Linear Hashing...");
            System.out.println("HashtableTest: Input " + lHash.getTotalElements() + " of which " + lHash.getDuplicteCount() + " duplicates");
            System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + lHash.probeAvg());

            System.out.println("\nHashtableTest: Using Double Hashing...");
            System.out.println("HashtableTest: Input " + dHash.getTotalElements() + " of which " + dHash.getDuplicteCount() + " duplicates");
            System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + dHash.probeAvg());
        }
        //Debug level 1
        else if(debugLevel == 1){
            try {
                lHash.dump("linear-dump.txt");
                dHash.dump("double-dump.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //Debug level 2
        else if(debugLevel == 2){
            System.out.println(lHash.toString());
            System.out.println(dHash.toString());

        }
    }

}

