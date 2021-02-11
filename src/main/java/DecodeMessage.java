import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {
    public static boolean isPossibleEncodedMessage(String encoded, String decoded) {
        if (null == encoded || null == decoded) return false;
        if (encoded.length() != decoded.length()) return false;
        char[] encodedArr = encoded.toCharArray();
        char[] decodedArr = decoded.toCharArray();
        int size = encoded.length();
        Map<Character, Character> encodedToDecoded = new HashMap<>();
        Map<Character, Character> decodedToEncoded = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (i > 0) {
                if (keyHasDifferentValue(encodedArr[i], decodedArr[i], encodedToDecoded)
                        || keyHasDifferentValue(decodedArr[i], encodedArr[i], decodedToEncoded)) return false;
            }
            encodedToDecoded.put(encodedArr[i], decodedArr[i]);
            decodedToEncoded.put(decodedArr[i], encodedArr[i]);
        }

        return true;
    }

    private static boolean keyHasDifferentValue(char key, char value, Map<Character, Character> charMap) {
        Character valueFound = charMap.get(key);
        if (valueFound == null) return false;
        if (!valueFound.equals(value)) return true;
        return false;
    }

}
