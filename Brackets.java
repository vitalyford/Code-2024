import java.util.*;

public class Brackets {
    public static boolean(String input) {
        Stack<????> stack = new Stack<>();
        for (char i: input.toCharArray()) {
            if (i)
        }
    }

    public static void main(String[] args) {
        // Abc[def]([)]ghij{kl}m - unbalanced
        String input = "Abc[defg]{i()jk}{l{mn}}op";

        System.out.println(checkBrackets(input));
    }
}
