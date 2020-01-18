import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sumTemp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumTemp * 2 + nums[i] == sum) {
                return i;
            }
            sumTemp += nums[i];
        }
        return -1;
    }
}

