import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Flights {
    public static void searchPath(String src, String dst, ArrayList<String> flightLetter) {
        Stack<String> stack = new Stack<>();
        // flightLetter = ["T W", "W Y"]
        ArrayList<String> visited = new ArrayList<>();

        stack.push(src);
        visited.add(src);

        // TODO: add a break to break the loop
        // if we didn't reach the dst
        while (!stack.peek().equals(dst)) {
            boolean foundNextCity = false;
            // Go to the next available place/city
            for (String path : flightLetter) {
                if (path.substring(0, 1).equals(stack.peek()) &&
                        !visited.contains(path.substring(2))) {
                    stack.push(path.substring(2));
                    visited.add(path.substring(2));
                    foundNextCity = true;
                    break;
                }
            }
            if (!foundNextCity) {
                stack.pop();

            }
            if (stack.isEmpty()) {
                System.out.println("Go Walking. --Jefferson");
                return;
            }
        }

        String out = "";

        while (!stack.isEmpty()) {
            out = stack.pop() + " -> " + out;
        }
        System.out.println(out);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("flights.txt"));

        ArrayList<String> flightletter = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            flightletter.add(line);
        }

        scan.close();

        scan = new Scanner(System.in);
        while (true) {
            System.out.print("Give me the src and dst: ");
            String[] line = scan.nextLine().split(" ");
            String src = line[0];
            String dst = line[1];

            // Ready to implement the algorithm
            searchPath(src, dst, flightletter);
        }
    }
}
