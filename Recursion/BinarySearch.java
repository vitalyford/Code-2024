package Recursion;
import java.util.Random;

public class BinarySearch {
    private static int guess;

    static {
        Random r = new Random();
        guess = r.nextInt(1000);
    }

    public BinarySearch() {
        Random r = new Random();
        guess = r.nextInt(1000);
    }

    /**
     * This method will return the number of steps it took 
     * to find the guessed number
     * @param low
     * @param high
     * @return guessed number
     */
    public static int search(int low, int high, int steps) {
        // if verify return true, we found it!
        int mid = (low + high) / 2;
        int test = verify(mid);
        if (test == 0) {
            return steps;
        }
        else if (test == -1) {
            return search(low, mid - 1, steps + 1);
        }
        else { // test == 1
            return search(mid + 1, high, steps + 1);
        }
    }

    /**
     * This method returns:
     *    -1 if the guess is less than midPoint
     *     0 if the guess equals midPoint
     *     1 if the guess is greater than midPoint
     * @param midPoint
     * @return
     */
    public static int verify(int midPoint) {
        if (guess < midPoint) {
            return -1;
        }
        else if (guess == midPoint) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int low = 0, high = 1000;

        int steps = search(low, high, 0);

        System.out.println(steps + " steps -> " + guess);
    }
}
