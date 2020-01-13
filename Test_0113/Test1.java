import java.util.HashMap;

public class Test {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = ransomNote.toCharArray();
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (char c : chars) {
            chars1[c - 'a']++;
        }
        chars = magazine.toCharArray();
        for (char c : chars) {
            chars2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chars1[i] > chars2[i]) {
                return false;
            }
        }
        return true;
    }


}