import java.util.*;

public class Test {
    public int[] searchRange(int[] nums, int target) {
        int[] temp = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                temp[0] = i + 1;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                temp[1] = i + 1;
                break;
            }
        }
        return temp;
    }
}

