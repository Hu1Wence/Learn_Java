import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public boolean isPalindrome(int x) {
        String s = new StringBuilder(String.valueOf(x)).reverse().toString();
        if (s.equals(String.valueOf(x))) {
            return true;
        }
        return false;
    }



}