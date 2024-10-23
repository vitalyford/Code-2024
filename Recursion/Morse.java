import java.util.*;

public class Morse {

    private static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0" };

    private static String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....--.-", "--...", "---..", "----.", "-----" };

    public static String getMappedLetter(String morse) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(morse)) {
                return morseCodes[i];
            }
        }
        return null;
    }

    public static void decode(ArrayList<String> result, String message, String word) {
        if (message.length() == 0) {
            result.add(word);
            return;
        }
        for (int i = 1; i <= 5; i++) {
            String decodedLetter = getMappedLetter(message.substring(0, i));
            if (decodedLetter != null) {
                decode(result, message, word + decodedLetter);
            }
        }
    }

    public static ArrayList<String> decodeMorse(String encMessage) {
        ArrayList<String> result = new ArrayList<>();

        decode(result, encMessage, "");

        return result;
    }

    public static void main(String[] args) {
        /**
         * The `decoded` array list should contain
         * ["tet", "ta", "nt", "k"] in any order
         * if you pass "-.-" as an argument
         */
        ArrayList<String> decoded = decodeMorse("-.-");
        System.out.println(decoded);
    }
}
