public class Count1 {
    public static void main(String[] args) {
        int num = 65;
        int check = 0;
        int count = 0;
        // 方法一：
        for (check = 0; check < 32; check++) {
            if (((num >> check) & 1) == 1) {
                count++;
            }
        }
        //方法二：
        while (num > 0) {
            count++;
            num = num & (num - 1);
        }
        System.out.println(count);
    }
}