package Recursion;

public class RecursionPractice {
    private static void buildReverseString(StringBuilder sb, String input, int index) {
        if (index >= 0) {
            sb.append(input.charAt(index));
            buildReverseString(sb, input, index - 1);
        }
    }

    public static String reverseString(String input) {
        StringBuilder out = new StringBuilder(input.length());
        buildReverseString(out, input, input.length() - 1);
        // StringBuilder out = new StringBuilder(input.length());
        // for (int i = input.length() - 1; i >= 0; i--) {
        //     out.append(input.charAt(i));
        // }
        return out.toString();
    }

    public static int rabbits(int months) {
        return months <= 2 
                ? 1 
                : rabbits(months - 1) + rabbits(months - 2);
        // int pairs = 0;
        // if (months <= 2) { // assumption: months is never <= 0
        //     return 1;
        // }

        // // a is 1 month before, b is 2 months before the current one
        // int a = 1, b = 1;

        // // fact: months is greater than 2
        // while (months != 2) {
        //     pairs = a + b;
        //     b = a;
        //     a = pairs;
        //     months--;
        // }
        // return pairs;
    }

    public static void towers(int n, String src, String dst, String spare) {
        if (n == 1) {
            System.out.println("Moving from " + src + " to " + dst);
        }
        else {
            towers(n - 1, src, spare, dst);
            towers(1, src, dst, spare);
            towers(n - 1, spare, dst, src);
        }
    }

    public static void main(String[] args) {
        // System.out.println(reverseString("A Santa lived as a devil at NASA"));
        // System.out.println(rabbits(10)); // 21?
        int n = 6;
        towers(n, "A", "B", "C");
    }
}
