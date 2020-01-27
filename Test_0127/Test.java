import java.util.*;

public class Test {
    public int compress(char[] chars) {
        int n = chars.length, cur = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && chars[j] == chars[i]) j++;
            chars[cur++] = chars[i];
            if (j - i == 1) continue;
            for (char c : String.valueOf(j - i).toCharArray()) chars[cur++] = c;
        }
        return cur;
    }
}

