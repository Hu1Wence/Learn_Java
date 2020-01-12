
//给定一个数组 nums 和一个值 val ，你需要原地移除所有数值等于 val 的元素，
// 你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
// 返回移除后数组的新长度。不要使用额外的数组空间，

public class Test {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[prev] = nums[i];
                prev++;
            }
        }
        return prev;
    }
}