import java.util.HashSet;
import java.util.Set;

class FindCharter {
    Set<Character> charSet = new HashSet<>();
    Set<Character> charRepeat = new HashSet<>();

    public char findFirstNonRepeatedChar(String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (charSet.contains(ch)) {
                charSet.remove(ch);
                charRepeat.add(ch);
            } else charSet.add(ch);
        }

        for (char ch : chars) {
            if (charSet.contains(ch))
                return ch;
        }
        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
