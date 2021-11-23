/**
 * This class is for generating a twin prime number. It includes two methods that work together to
 * locate and return the first twin prime in the range.
 * @author emilymead
 * @version Fall 2021
 */
public class TwinPrimeGenerator {

    public static void main(String[] args) {
        System.out.println(twinPrime());
    }
    /**
     * the isPrime method checks to see if the number being passed in is prime or not and returns
     * the corisponding boolean
     * @param number is the number that is being checked if its prime or not
     * @return true if number is prime and false if the number is not prime
     */
    public static boolean isPrime(int number){
        for(int i = 2; i < number/2; i++){
            if((number % i) == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * the twinPrime method looks for a number in the range 95500 - 96000 that is prime and when that number
     * minus to is also prime
     * @return twinPrime when twinPrime and twinPrime - 1 are both prime numbers.
     */
    public static int twinPrime(){
        int lowerBound = 95500;
        int upperBound = 96000;
        int twinPrime = 0;
        for(int i = lowerBound; i < 96000; i++){
            if(isPrime(i) && isPrime(i - 2)){
                //System.out.println(i + " is our twin prime number");
                twinPrime = i;
                break;
            }
        }
        return twinPrime;
    }
}