import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public String reverseOnlyLetters(String S) {
        char[] chars= S.toCharArray();
        int cur = 0;
        int bound = chars.length - 1;

        while (cur < bound) {
            while (cur < bound && !isletter(chars[cur])) {
                cur++;
            }
            while (cur < bound && !isletter(chars[bound])) {
                bound--;
            }
            char c = chars[cur];
            chars[cur] = chars[bound];
            chars[bound] = c;
            cur++;
            bound--;
        }
        return new String(chars);
    }

    public static boolean isletter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

}

