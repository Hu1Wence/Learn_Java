import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static boolean isLongPressedName(String name, String typed) {
        int name_index = 0;
        int typed_index = 0;
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        if (names[name_index] != typeds[typed_index]) {
            return false;
        }
        while (name_index < names.length || typed_index < typeds.length) {
            if (names[name_index] != typeds[typed_index]) {
                return false;
            }
            while (typed_index < typeds.length && names[name_index] == typeds[typed_index]) {
                typed_index++;
            }
            name_index++;
        }
        return true;
    }

    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        System.out.println(isLongPressedName(name, typed));
    }

}

