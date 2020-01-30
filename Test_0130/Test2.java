import java.util.*;

public class Test {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(nums);
        int i, j;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                break;
            }
        }
        for (j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != temp[j]) {
                break;
            }
        }
        if (i == nums.length && j == -1) {
            return 0;
        }
        return j - i + 1;
    }
}

