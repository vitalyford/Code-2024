import java.util.*;

public class Brackets {
    public static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        for (char i: input.toCharArray()) {
            if (i == '(' || i == '{' || i == '[') {
                stack.push(i);
            }
            else if (i == ')' || i == '}' || i == ']') {
                if (stack.isEmpty()) {
                    return false;
                } 
                if (Math.abs(stack.peek() - i) > 2) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String balancedInput   = "Abc[defg]{i()jk}{l{mn}}op";
        String unbalancedInput = "Abc[def]([)]ghij{kl}m";

        System.out.println(checkBrackets(balancedInput));   // true
        System.out.println(checkBrackets(unbalancedInput)); // false
    }
}
